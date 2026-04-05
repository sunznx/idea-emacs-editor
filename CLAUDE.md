# CLAUDE.md

> 本文件是通用项目配置模板，由 skill 统一管理。
> 不包含本地/敏感信息，可安全提交到仓库。

## Repository Overview

**idea-emacs-editor** - 将 IntelliJ IDEA 打造为 Emacs 风格编辑器的插件

提供 Emacs 经典功能的 IDEA 实现：
- `C-x C-f` find-file（快速文件查找）
- Vertico 风格的补全界面
- 模糊匹配和文件预览

**当前状态**: Active development

## Directory Structure

```text
idea-emacs-editor/
├── src/main/java/com/github/sunznx/idea/emacs/editor/
│   └── find/                    # 文件查找功能模块
│       ├── FindFileAction.java  # C-x C-f 动作入口
│       ├── DirCache.java         # 目录缓存服务
│       └── vertico/              # Vertico 风格 UI（待实现）
├── src/test/java/                # JUnit 5 测试
├── src/main/resources/META-INF/
│   └── plugin.xml               # 插件配置
├── build.gradle.kts              # Gradle 构建配置
└── gradle.properties            # Gradle 属性设置
```

## Code Organization

### IntelliJ Platform 插件模式

**Action System**:
- 继承 `AnAction` 实现自定义动作
- 在 `plugin.xml` 中注册并配置快捷键
- 使用 `update()` 方法控制动作可用性

**Application Service**:
- 使用 `@Service(Service.Level.APP)` 注解
- 通过 `ApplicationManager.getService()` 获取实例
- 用于跨项目的全局缓存和状态

**Virtual File System (VFS)**:
- 使用 `VirtualFile` 抽象文件系统操作
- 支持本地和远程文件统一处理

### Error Handling

```java
// 快速失败原则
public void actionPerformed(@NotNull AnActionEvent e) {
    Project project = e.getProject();
    if (project == null) return;  // 前置检查
    
    try {
        // 执行逻辑
    } catch (Exception ex) {
        // 记录错误，不静默吞掉
        LOG.error("Find file failed", ex);
    }
}
```

## Testing Strategy

- **框架**: JUnit 5 (Jupiter)
- **命令**: `./gradlew test`
- **覆盖率**: ≥80%（继承全局配置）
- **测试位置**: `src/test/java/` 镜像主包结构

```java
@Test
void shouldInstantiate() {
    FindFileAction action = new FindFileAction();
    assertNotNull(action, "Action should be instantiated");
}
```

## Available Commands

| 命令 | 用途 |
|------|------|
| `./gradlew build` | 构建插件 |
| `./gradlew test` | 运行测试 |
| `./gradlew runIde` | 启动开发环境 sandbox |
| `./gradlew buildPlugin` | 构建插件分发包 |

## Git Workflow

- **分支命名**: `feat/xxx`, `fix/xxx`, `refactor/xxx`
- **提交格式**: `<type>: <description>`
  - `feat:` - 新功能
  - `fix:` - Bug 修复
  - `refactor:` - 重构
  - `test:` - 测试相关
  - `docs:` - 文档
- **PR 目标**: `main` 分支

## IntelliJ Platform 兼容性

- **最低版本**: 2023.3 (build 233)
- **目标版本**: 2024.1 (build 241.*)
- **Java 版本**: 17
- **Gradle 版本**: 8.5

## Development Notes

- **保持轻量**: 优先使用平台 API，避免引入重依赖
- **缓存优先**: 文件列表等需要缓存以提高性能
- **异步操作**: 文件系统操作使用异步 API 避免阻塞
- **测试驱动**: 新功能先写测试再实现

## 推荐技能

在开发此项目时，以下技能会很有帮助：

- `seeker-intellij-plugin` — IntelliJ Platform 插件开发模式和最佳实践
- `kotlin-patterns` — Kotlin DSL 编写技巧（build.gradle.kts）
- `java-coding-standards` — Java 17 编码规范
