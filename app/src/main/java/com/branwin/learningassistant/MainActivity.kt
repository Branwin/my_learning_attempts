package com.branwin.learningassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CollectionsBookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.Sync

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LearningAssistantApp() }
    }
}

private data class Destination(
    val label: String,
    val icon: ImageVector,
)

@Composable
private fun LearningAssistantApp() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val destinations = listOf(
        Destination("首页", Icons.Outlined.Home),
        Destination("课程", Icons.Outlined.CalendarMonth),
        Destination("收藏", Icons.Outlined.CollectionsBookmark),
        Destination("我的", Icons.Outlined.Person),
    )

    MaterialTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    destinations.forEachIndexed { index, destination ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            icon = { Icon(destination.icon, contentDescription = destination.label) },
                            label = { Text(destination.label) },
                        )
                    }
                }
            },
        ) { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                when (selectedIndex) {
                    0 -> HomeScreen()
                    1 -> CourseScreen()
                    2 -> CollectionsScreen()
                    else -> ProfileScreen()
                }
            }
        }
    }
}

@Composable
private fun HomeScreen() {
    LazyColumn(modifier = Modifier.padding(20.dp)) {
        item {
            Text("今天也要保持学习", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text("把灵感变成可以复习的知识点。")
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("搜索知识点标题") },
                singleLine = true,
            )
            Spacer(Modifier.height(24.dp))
            SectionHeader("每日推荐", "换一批")
            RecommendationCard()
            Spacer(Modifier.height(24.dp))
            SectionHeader("今日计划", "查看全部")
            PlanItem("复习数据结构：二叉树", "计算机基础 · 25 分钟", false)
            Spacer(Modifier.height(8.dp))
            PlanItem("整理英语阅读笔记", "英语 · 15 分钟", true)
        }
    }
}

@Composable
private fun SectionHeader(title: String, action: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        TextButton(onClick = {}) { Text(action) }
    }
}

@Composable
private fun RecommendationCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AssistChip(onClick = {}, label = { Text("计算机基础") })
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.BookmarkBorder, contentDescription = "收藏")
                }
            }
            Text("理解复杂度：从 Big O 开始", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text("用渐进表示法描述算法的时间与空间开销，建立分析算法效率的基础。")
            Spacer(Modifier.height(16.dp))
            Button(onClick = {}) {
                Icon(Icons.Outlined.AddTask, contentDescription = null)
                Text("加入今日计划", Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Composable
private fun PlanItem(title: String, subtitle: String, completed: Boolean) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(if (completed) "✓" else "○", style = MaterialTheme.typography.titleLarge)
            Column(Modifier.padding(start = 12.dp)) {
                Text(title, fontWeight = FontWeight.Medium)
                Text(subtitle, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.weight(1f))
            Text("☷")
        }
    }
}

@Composable
private fun CourseScreen() {
    LazyColumn(modifier = Modifier.padding(20.dp)) {
        item {
            Text("课程表", style = MaterialTheme.typography.headlineSmall)
            Text("管理课程，并将知识点关联到对应课程。")
            Spacer(Modifier.height(24.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(Icons.Outlined.CloudUpload, contentDescription = null)
                    Text("导入课表", style = MaterialTheme.typography.titleLarge)
                    Text("第一阶段先搭建入口。OCR 上传与预览将在后续阶段接入。")
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = {}) { Text("选择课表图片") }
                }
            }
            Spacer(Modifier.height(24.dp))
            Text("本学期", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            CourseItem("数据结构", "周一 08:00 - 09:40 · 教学楼 A101")
            CourseItem("英语阅读", "周三 10:00 - 11:40 · 教学楼 B203")
        }
    }
}

@Composable
private fun CourseItem(name: String, detail: String) {
    Card(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.MenuBook, contentDescription = null)
            Column(Modifier.padding(start = 12.dp)) {
                Text(name)
                Text(detail, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.weight(1f))
            Icon(Icons.Outlined.ChevronRight, contentDescription = null)
        }
    }
}

@Composable
private fun CollectionsScreen() {
    LazyColumn(modifier = Modifier.padding(20.dp)) {
        item {
            Text("我的收藏", style = MaterialTheme.typography.headlineSmall)
            Text("按集合整理你的知识卡片。")
            Spacer(Modifier.height(24.dp))
            CollectionItem("计算机基础", "12 个知识点", Icons.Outlined.Code)
            CollectionItem("英语阅读", "8 个知识点", Icons.Outlined.MenuBook)
            CollectionItem("待整理", "3 个知识点", Icons.Outlined.CollectionsBookmark)
        }
    }
}

@Composable
private fun CollectionItem(title: String, detail: String, icon: ImageVector) {
    Card(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null)
            Column(Modifier.padding(start = 12.dp)) {
                Text(title)
                Text(detail, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.weight(1f))
            Icon(Icons.Outlined.ChevronRight, contentDescription = null)
        }
    }
}

@Composable
private fun ProfileScreen() {
    LazyColumn(modifier = Modifier.padding(20.dp)) {
        item {
            Text("我的", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(20.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(20.dp)) {
                    Text("本地学习者", style = MaterialTheme.typography.titleLarge)
                    Text("第一阶段：本地模式")
                }
            }
            Spacer(Modifier.height(24.dp))
            Text("设置", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            SettingItem(Icons.Outlined.Palette, "主题外观", "浅色主题")
            SettingItem(Icons.Outlined.Sync, "数据同步", "Firebase 将在后续阶段接入")
            SettingItem(Icons.Outlined.PrivacyTip, "隐私说明", "了解 OCR 上传与数据存储")
        }
    }
}

@Composable
private fun SettingItem(icon: ImageVector, title: String, subtitle: String) {
    Card(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null)
            Column(Modifier.padding(start = 12.dp)) {
                Text(title)
                Text(subtitle, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.weight(1f))
            Icon(Icons.Outlined.ChevronRight, contentDescription = null)
        }
    }
}
