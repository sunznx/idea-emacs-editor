package com.github.sunznx.idea.emacs.editor.find;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * Emacs-style find file action (C-x C-f).
 * TODO: Implement proper file selection dialog.
 */
public class FindFileAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }

        VirtualFile currentFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        String message = currentFile != null 
            ? "Current file: " + currentFile.getPath()
            : "No file open. Project base: " + project.getBasePath();
        
        Messages.showInfoMessage(message, "Emacs Find File (C-x C-f)\n\nTODO: Implement file selection dialog with:\n- Path input field\n- File name completion\n- Vertico-style candidate list");
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        e.getPresentation().setEnabledAndVisible(project != null);
    }
}
