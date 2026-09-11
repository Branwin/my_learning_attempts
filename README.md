# 学习助手

学习辅助知识点收藏 App，首版目标平台为 Android，使用 Kotlin + Jetpack Compose 构建。

## 第一阶段：工程骨架

当前阶段完成了：

- 原生 Android Kotlin 应用入口与 Material 3 Compose UI；
- 首页、课程、收藏、我的四个主导航页面；
- 首页搜索框、每日推荐、今日计划的静态交互入口；
- 课程导入、集合管理、个人设置的占位入口；
- 一个覆盖启动和主导航切换的 widget test。

当前阶段暂不接入 Firebase、OCR、登录和本地数据库。页面中的示例数据是静态数据，后续阶段会替换为 repository 和本地持久化数据源。

## 在 Android Studio 中运行

1. 安装 Android Studio，并在 SDK Manager 中确认安装 Android SDK Platform、Platform-Tools、Build-Tools 和 Command-line Tools。
2. 在 Android Studio 中打开本仓库根目录，不要只打开 `app` 子目录。
3. 等待 Gradle Sync 完成。如果 Android Studio 提示选择 Gradle JDK，选择 **Embedded JDK 17**。
4. 用 Android Studio 的 Device Manager 创建或启动一个 Android 模拟器；也可以连接已打开 USB 调试的实体设备。
5. 在 Android Studio 顶部设备选择器选中设备，点击 Run。首次打开项目时 Android Studio 会自动使用项目的 Gradle 配置下载依赖。
6. 生成的 `local.properties`、签名文件或本机 SDK 路径不要提交。

## 后续阶段建议

1. 接入本地数据层和 Card/Course/Collection/PlanItem 模型；
2. 接入 Firebase Auth、Firestore 和 Cloud Storage；
3. 实现知识卡片 CRUD、离线同步与冲突中心；
4. 实现 OCR 上传确认、识别预览和课程导入。
