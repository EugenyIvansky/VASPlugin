package com.vasplugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceService;
import com.vasplugin.psi.VASContributedReferenceHost;
import com.vasplugin.psi.VASNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class VASContributedReferenceHostImpl extends ASTWrapperPsiElement implements VASContributedReferenceHost {

    public VASContributedReferenceHostImpl(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        return PsiReferenceService.getService().getContributedReferences(this);
    }
}
