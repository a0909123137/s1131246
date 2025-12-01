package tw.edu.pu.csim.tcyang.s1131246

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ExamScreen(viewModel: ExamViewModel = viewModel()) {
    // 取得螢幕尺寸
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    // 收集成績狀態
    val score by viewModel.score.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // 圖片
            Image(
                painter = painterResource(id = R.drawable.happy),
                contentDescription = "服務圖片",
                modifier = Modifier
                    .size(280.dp)
                    .padding(bottom = 40.dp)
            )

            // 考試名稱
            Text(
                text = "瑪利亞基金會服務大考驗",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // 作者資訊
            Text(
                text = "作者：資管二A 林煥杰",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // 螢幕尺寸
            Text(
                text = "螢幕大小：$screenWidth.0 * $screenHeight.0",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // 成績
            Text(
                text = "成績：${score}分",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}