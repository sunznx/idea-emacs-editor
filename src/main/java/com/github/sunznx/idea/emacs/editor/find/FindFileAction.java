package com.github.sunznx.idea.emacs.editor.find;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Emacs-style find file action (C-x C-f).
 * Opens a file selection dialog with Vertico-style completion.
 */
public class FindFileAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }

        VirtualFile currentFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        
        // TODO: Implement Vertico-style file selection dialog
        // For now, just show a message
        com.intellij.openapi.ui.Messages.showInfoMessage(
            "Find File: " + (currentFile != null ? currentFile.getPath() : "no file"),
            "Emacs Find File"
        );
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        e.getPresentation().setEnabledAndVisible(project != null);
    }
}
