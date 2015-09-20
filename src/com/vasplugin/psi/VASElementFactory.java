package com.vasplugin.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.vasplugin.VASFileType;

public class VASElementFactory {
    public static com.vasplugin.psi.VASMacroImpl createMacroImpl(Project project, String name) {
        final VASFile file = createFileWithMacroImpl(project, name);
        return (com.vasplugin.psi.VASMacroImpl) file.getFirstChild();
    }

    public static com.vasplugin.psi.VASMacros createMacros(Project project, String name) {
        final VASFile file = createFileWithMacros(project, name);
        return (com.vasplugin.psi.VASMacros) file.getFirstChild();
    }

    public static com.vasplugin.psi.VASEntity createEntity(Project project, String name) {
        final VASFile file = createFileWithEntity(project, name);
        return (com.vasplugin.psi.VASEntity) file.getFirstChild();
    }

    public static VASFile createFileWithEntity(Project project, String text) {
        String name = "dummy.vas";
        return (VASFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, VASFileType.INSTANCE, "{ \"id\" : \" " + text + " \"}");
    }

    public static VASFile createFileWithMacroImpl(Project project, String text) {
        String name = "dummy.vas";
        return (VASFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, VASFileType.INSTANCE, "#macro(" + text + ") #end");
    }

    public static VASFile createFileWithMacros(Project project, String text) {
        String name = "dummy.vas";
        return (VASFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, VASFileType.INSTANCE, "#" + text);
    }
}
