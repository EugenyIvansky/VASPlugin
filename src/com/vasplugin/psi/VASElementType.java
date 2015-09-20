package com.vasplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.vasplugin.VASLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VASElementType extends IElementType {
    public VASElementType(@NotNull @NonNls String debugName) {
        super(debugName, VASLanguage.INSTANCE);
    }
}