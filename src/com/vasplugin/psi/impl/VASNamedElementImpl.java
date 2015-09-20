package com.vasplugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.vasplugin.psi.VASNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class VASNamedElementImpl extends ASTWrapperPsiElement implements VASNamedElement {
    public VASNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
