package com.vasplugin;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.vasplugin.psi.VASEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VASEntityReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String name;

    public VASEntityReference(@NotNull PsiElement element, String name, TextRange textRange) {
        super(element, textRange);
        this.name = name;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<VASEntity> entities = VASUtil.findEntity(project, name);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (VASEntity entity : entities) {
            results.add(new PsiElementResolveResult(entity));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<VASEntity> entities = VASUtil.findEntity(project);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final VASEntity entity : entities) {
            if (entity.getName() != null && entity.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(entity).
                                withIcon(VASIcons.FILE).
                                withTypeText(entity.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
