package com.vasplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.vasplugin.VASFileType;
import com.vasplugin.VASLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class VASFile extends PsiFileBase {
    public VASFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, VASLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VASFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "VAS File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
