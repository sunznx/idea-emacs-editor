# CLAUDE.local.md

> 本文件是本地覆盖配置，包含个人偏好、本地路径、敏感信息。
> 不提交到仓库。

## 本地开发环境

### Java 环境
| 工具 | 版本/路径 |
|------|----------|
| **Gradle JVM** | Java 17 (`/opt/homebrew/Cellar/openjdk@17/17.0.18/libexec/openjdk.jdk/Contents/Home`) |
| **项目 SDK** | Java 17 |
| **语言级别** | Java 17 |

### 环境变量
无特殊环境变量要求。

### 本地工具
- **IDE**: IntelliJ IDEA 2025.3
- **构建工具**: Gradle 8.5 (通过 Wrapper)
- **包管理**: Maven Central (通过 Gradle)

### Gradle 配置

已在 `gradle.properties` 中配置：
```properties
org.gradle.java.home=/opt/homebrew/Cellar/openjdk@17/17.0.18/libexec/openjdk.jdk/Contents/Home
```

### 开发偏好

**快捷键习惯**:
- Emacs 风格键位绑定
- 使用 `C-x C-f` 触发文件查找

**测试策略**:
- 使用 JUnit 5 编写单元测试
- 优先使用 Fake 而非 Mock
- 测试覆盖率目标 ≥80%

**IDE 设置**:
- 启用自动编译
- 启用保存时自动格式化
- 字体: JetBrains Mono (或等宽字体)

### 调试配置

**Sandbox 模式运行**:
- 使用 `./gradlew runIde` 启动测试环境
- 热重载: 修改代码后点击 "Restart Sandbox"

**插件安装测试**:
- 构建插件: `./gradlew buildPlugin`
- 在测试 IDE 中: `Settings → Plugins → ⚙️ → Install Plugin from Disk`
- 选择 `build/distributions/idea-emacs-editor-0.1.0.zip`

### 常见问题

**构建失败 - Java 版本不兼容**:
- 确保 `gradle.properties` 中 `org.gradle.java.home` 指向 Java 17
- 在 IDEA 中: `Settings → Build Tools → Gradle` → 设置 Gradle JVM 为 Java 17

**测试失败 - 找不到平台类**:
- 运行 `./gradlew clean test` 重新构建
- 确保 IntelliJ Platform 依赖正确下载

**快捷键不生效**:
- 在 sandbox 中检查 `Settings → Keymap` → 搜索 "Emacs"
- 确认 `C-x C-f` 组合键已正确注册
