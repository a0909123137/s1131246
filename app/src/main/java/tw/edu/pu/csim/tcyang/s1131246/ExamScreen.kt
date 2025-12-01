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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ExamScreen(viewModel: ExamViewModel = viewModel()) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    // 取得螢幕真實的像素尺寸
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }.toInt()
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }.toInt()

    // 收集成績狀態
    val score by viewModel.score.collectAsState()

    // 圖示尺寸為 300px，轉換為 dp
    val iconSizePx = 300
    val iconSizeDp = with(density) { iconSizePx.toDp() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        // 中央內容區
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                // 中央圓形圖片
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

                // 螢幕尺寸（顯示真實像素）
                Text(
                    text = "螢幕大小：$screenWidthPx.0 * $screenHeightPx.0",
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

        // 左上角 - 嬰幼兒圖示（role0.png）- 切齊螢幕中線
        Image(
            painter = painterResource(id = R.drawable.role0),
            contentDescription = "嬰幼兒",
            modifier = Modifier
                .size(iconSizeDp)
                .align(Alignment.TopStart)
                .offset(y = configuration.screenHeightDp.dp / 2 - iconSizeDp),
            contentScale = ContentScale.Fit
        )

        // 右上角 - 兒童圖示（role1.png）- 切齊螢幕中線
        Image(
            painter = painterResource(id = R.drawable.role1),
            contentDescription = "兒童",
            modifier = Modifier
                .size(iconSizeDp)
                .align(Alignment.TopEnd)
                .offset(y = configuration.screenHeightDp.dp / 2 - iconSizeDp),
            contentScale = ContentScale.Fit
        )

        // 左下角 - 成人圖示（role2.png）
        Image(
            painter = painterResource(id = R.drawable.role2),
            contentDescription = "成人",
            modifier = Modifier
                .size(iconSizeDp)
                .align(Alignment.BottomStart),
            contentScale = ContentScale.Fit
        )

        // 右下角 - 一般民眾圖示（role3.png）
        Image(
            painter = painterResource(id = R.drawable.role3),
            contentDescription = "一般民眾",
            modifier = Modifier
                .size(iconSizeDp)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.Fit
        )
    }
}