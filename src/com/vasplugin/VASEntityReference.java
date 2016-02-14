package com.vasplugin;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

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
        List<ResolveResult> resolveResults = VASUtil.findEntity(project, name).stream()
                .map(entity -> new PsiElementResolveResult(entity))
                .collect(Collectors.toList());

        return resolveResults.toArray(new ResolveResult[resolveResults.size()]);
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

        List<LookupElement> variants = VASUtil.findEntity(project).stream()
                .filter(entity -> StringUtils.isEmpty(entity.getName()))
                .map(entity -> LookupElementBuilder.create(entity).withIcon(VASIcons.FILE).withTypeText(entity.getContainingFile().getName()))
                .collect(Collectors.toList());

        return variants.toArray();
    }
}
