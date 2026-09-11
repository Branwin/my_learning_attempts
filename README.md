# 学习助手

学习辅助知识点收藏 App，首版目标平台为 Android，使用 Flutter 构建。

## 第一阶段：工程骨架

当前阶段完成了：

- Flutter 应用入口与 Material 3 主题；
- 首页、课程、收藏、我的四个主导航页面；
- 首页搜索框、每日推荐、今日计划的静态交互入口；
- 课程导入、集合管理、个人设置的占位入口；
- 一个覆盖启动和主导航切换的 widget test。

当前阶段暂不接入 Firebase、OCR、登录和本地数据库。页面中的示例数据是静态数据，后续阶段会替换为 repository 和本地持久化数据源。

## 在 Android Studio 中运行

1. 安装 Flutter SDK，并把 Flutter SDK 的 `bin` 目录加入系统 PATH。Android Studio 本身不是 Flutter SDK，首次运行前还需要在 Android Studio 的 Plugins 中安装 **Flutter** 插件（它会同时安装 Dart 插件）。
2. 在 Android Studio 中打开本仓库根目录，不要只打开 `android` 子目录。
3. 打开 Terminal，在仓库根目录执行：

   ```bash
   flutter doctor
   flutter create --platforms=android .
   flutter pub get
   ```

   `flutter create` 会根据当前 Flutter SDK 生成 Android 宿主目录。根据 `flutter doctor` 的提示安装 Android SDK、Android SDK Command-line Tools，并在 Android Studio 的 SDK Manager 中确认至少有一个 Android SDK Platform。
4. 用 Android Studio 的 Device Manager 创建或启动一个 Android 模拟器；也可以连接已打开 USB 调试的实体设备。
5. 执行：

   ```bash
   flutter devices
   flutter run
   ```

   或在 Android Studio 顶部设备选择器选中设备后点击 Run。
6. 运行测试：

   ```bash
   flutter test
   ```

生成 Android 平台目录后，不要提交 `android/local.properties`、签名文件或本机 SDK 路径；这些文件已经在 `.gitignore` 中排除。

## 后续阶段建议

1. 接入本地数据层和 Card/Course/Collection/PlanItem 模型；
2. 接入 Firebase Auth、Firestore 和 Cloud Storage；
3. 实现知识卡片 CRUD、离线同步与冲突中心；
4. 实现 OCR 上传确认、识别预览和课程导入。
