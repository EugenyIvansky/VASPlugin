package com.vasplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class VASFileType extends LanguageFileType {
    public static final VASFileType INSTANCE = new VASFileType();

    private VASFileType() {
        super(VASLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "VAS file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "VAS language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "vastxt";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return VASIcons.FILE;
    }
}
