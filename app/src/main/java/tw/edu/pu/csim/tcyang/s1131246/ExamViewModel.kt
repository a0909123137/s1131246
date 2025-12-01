package tw.edu.pu.csim.tcyang.s1131246

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class ExamViewModel : ViewModel() {
    // 成績狀態
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score.asStateFlow()

    // 服務圖示位置（像素）
    private val _serviceX = MutableStateFlow(0f)
    val serviceX: StateFlow<Float> = _serviceX.asStateFlow()

    private val _serviceY = MutableStateFlow(0f)
    val serviceY: StateFlow<Float> = _serviceY.asStateFlow()

    // 當前顯示的服務圖示 (0, 1, 2, 3 對應 service0, service1, service2, service3)
    private val _currentService = MutableStateFlow(0)
    val currentService: StateFlow<Int> = _currentService.asStateFlow()

    private var fallJob: Job? = null

    // 初始化：隨機選擇服務圖示
    init {
        _currentService.value = Random.nextInt(4)
    }

    // 開始下落動畫
    fun startFalling(screenWidth: Float, screenHeight: Float) {
        fallJob?.cancel()

        // 初始化位置：水平中間，螢幕上方
        _serviceX.value = screenWidth / 2
        _serviceY.value = 0f

        fallJob = viewModelScope.launch {
            while (true) {
                delay(100) // 每0.1秒

                // 往下掉20px
                _serviceY.value += 20f

                // 如果碰到螢幕下方，回到上方，並隨機換一個服務圖示
                if (_serviceY.value >= screenHeight) {
                    _serviceY.value = 0f
                    _currentService.value = Random.nextInt(4)
                }
            }
        }
    }

    // 停止下落
    fun stopFalling() {
        fallJob?.cancel()
    }

    // 更新 X 座標（拖曳用）
    fun updateServiceX(newX: Float) {
        _serviceX.value = newX
    }

    // 更新成績
    fun updateScore(newScore: Int) {
        _score.value = newScore
    }

    // 重置成績
    fun resetScore() {
        _score.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        stopFalling()
    }
}