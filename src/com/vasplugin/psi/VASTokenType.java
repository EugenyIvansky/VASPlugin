package com.vasplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.vasplugin.VASLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VASTokenType extends IElementType {
    public VASTokenType(@NotNull @NonNls String debugName) {
        super(debugName, VASLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "VASTokenType." + super.toString();
    }
}
