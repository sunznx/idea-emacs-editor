package com.github.sunznx.idea.emacs.editor.find;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Caches directory listings for faster file navigation.
 */
@Service(Service.Level.APP)
public final class DirCache {

    private final Map<String, VirtualFile[]> cache = new HashMap<>();

    public static DirCache getInstance() {
        return ApplicationManager.getApplication().getService(DirCache.class);
    }

    public VirtualFile @NotNull [] getChildren(@NotNull VirtualFile directory) {
        String path = directory.getPath();
        
        VirtualFile[] cached = cache.get(path);
        if (cached != null) {
            return cached;
        }

        VirtualFile[] children = directory.getChildren();
        if (children != null) {
            cache.put(path, children);
        }
        
        return children != null ? children : new VirtualFile[0];
    }

    public void invalidate(@NotNull VirtualFile directory) {
        cache.remove(directory.getPath());
    }

    public void clear() {
        cache.clear();
    }
}
