package com.vasplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.SmartList;
import com.intellij.util.indexing.FileBasedIndex;
import com.vasplugin.psi.VASEntity;
import com.vasplugin.psi.VASFile;
import com.vasplugin.psi.VASMacroImpl;
import com.vasplugin.psi.VASMacros;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VASUtil {

    public static List<VASMacroImpl> findMacros(Project project, String name) {
        List<VASMacroImpl> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VASFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VASFile vasFile = (VASFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (vasFile != null) {
                VASMacroImpl[] macros = PsiTreeUtil.getChildrenOfType(vasFile, VASMacroImpl.class);
                if (macros != null) {
                    for (VASMacroImpl macro : macros) {
                        if (name.equals(macro.getName())) {
                            if (result == null) {
                                result = new ArrayList<VASMacroImpl>();
                            }
                            result.add(macro);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<VASMacroImpl>emptyList();
    }

    public static List<VASMacroImpl> findMacros(Project project) {
        List<VASMacroImpl> result = new ArrayList<VASMacroImpl>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VASFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VASFile vasFile = (VASFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (vasFile != null) {
                VASMacroImpl[] macros = PsiTreeUtil.getChildrenOfType(vasFile, VASMacroImpl.class);
                if (macros != null) {
                    Collections.addAll(result, macros);
                }
            }
        }
        return result;
    }

    public static List<VASEntity> findEntity(Project project, String name) {
        List<VASEntity> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VASFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VASFile vasFile = (VASFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (vasFile != null) {
                List<VASEntity> allEntities = new ArrayList<>();
                getAllEntities(allEntities, vasFile);
                for (VASEntity entity : allEntities) {
                    if (name.equals(entity.getName())) {
                        if (result == null) {
                            result = new ArrayList<VASEntity>();
                        }
                        result.add(entity);
                    }
                }

            }
        }
        return result != null ? result : Collections.<VASEntity>emptyList();
    }

    public static List<VASEntity> findEntity(Project project) {
        List<VASEntity> result = new ArrayList<VASEntity>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VASFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VASFile vasFile = (VASFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (vasFile != null) {
                getAllEntities(result, vasFile);
            }
        }
        return result;
    }

    @Nullable
    public static void getAllEntities(List<VASEntity> entities, @Nullable PsiElement element) {
        PsiElement[] childs = element.getChildren();
        for (PsiElement child : childs){
            if(VASEntity.class.isInstance(child)) {
                VASEntity entity = (VASEntity)child;
                if(entity.getName() != null){
                    entities.add(entity);
                }
            }

            getAllEntities(entities, child);
        }
    }
}
