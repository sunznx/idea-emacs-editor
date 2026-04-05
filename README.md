# Emacs Editor for IntelliJ IDEA

Emacs-style editing experience for IntelliJ IDEA with fast file navigation, cross-project recent files, and kill-ring integration.

## Features

### 1. Find File (C-x C-f)

Fast file navigation with fuzzy path completion, inspired by Emacs' `find-file`.

- **Fuzzy matching**: Type `/Us` to see both `/Users` (case-sensitive) and `/usr` (case-insensitive)
- **Directory navigation**: Select directories to enter them
- **Path shortcuts**:
  - `~/` - Go to home directory
  - `//` - Go to root directory
  - `-` - Go to last visited directory
- **Default path**: Starts from current file's directory
- **Keyboard shortcuts in find-file popup**:
  - `Ctrl+N` / `↓` - Next item in list
  - `Ctrl+P` / `↑` - Previous item in list
  - `Ctrl+I` / `Tab` / `Enter` - Select current item
  - `Ctrl+W` - Kill region or backward word
  - `Alt+B` - Backward word
  - `Alt+F` - Forward word
  - `Ctrl+G` / `Esc` - Cancel

### 2. Cross-Project Recent Files (C-x C-r)

Shared file history across all projects.

- Tracks all opened files across all projects
- Accessible via keyboard shortcut: `C-x C-r`
- Configurable history size (default: 99999)
- Fast file switching without project boundaries

### 3. Kill Ring (Ctrl+W)

Emacs-style kill-ring synchronized with system clipboard.

- Kills selected text or backward word with `Ctrl+W`
- Circular kill-ring with configurable size (default: 9999)
- Bidirectional sync with system clipboard
- Works seamlessly with OS copy/paste

## Configuration

All settings are available at: **Settings → Tools → Emacs Editor**

### History Settings

- **Recent Files History Size**: Maximum number of recent files to track (default: 99999)
- **Kill Ring Size**: Maximum number of kills to store (default: 9999)

### Keyboard Shortcuts

All shortcuts are customizable in the settings:

**Find File Shortcuts**:
- Next Item: `control N`
- Previous Item: `control P`
- Select: `control I`
- Kill: `control W`
- Backward Word: `alt B`
- Forward Word: `alt F`

**Action Shortcuts**:
- Find File Action: `control X control F`
- Open Recent Action: `control X control R`
- Kill Region Action: `control W`

## Installation

### From Plugin Repository

1. Go to **Settings → Plugins**
2. Search for "Emacs Editor"
3. Click **Install**

### From Source

1. Clone the repository
2. Build the plugin: `./gradlew buildPlugin`
3. Install the resulting ZIP file from **Settings → Plugins → ⚙️ → Install Plugin from Disk**

## Requirements

- IntelliJ IDEA 2023.3 or later
- JBR 17 or later

## Development

### Building

```bash
./gradlew buildPlugin
```

### Running in Development

```bash
./gradlew runIde
```

### Verifying

```bash
./gradlew verifyPlugin
```

## License

MIT License

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Changelog

### 0.1.0
- Initial release
- Find File with fuzzy path completion
- Cross-project recent files
- Kill-ring with clipboard sync
- Customizable keyboard shortcuts
