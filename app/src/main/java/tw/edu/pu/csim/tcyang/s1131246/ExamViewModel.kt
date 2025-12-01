package tw.edu.pu.csim.tcyang.s1131246

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExamViewModel : ViewModel() {
    // 成績狀態
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score.asStateFlow()

    // 更新成績的方法
    fun updateScore(newScore: Int) {
        _score.value = newScore
    }

    // 重置成績
    fun resetScore() {
        _score.value = 0
    }
}