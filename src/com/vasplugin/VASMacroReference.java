package com.vasplugin;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.vasplugin.psi.VASMacroImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VASMacroReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String name;

    public VASMacroReference(@NotNull PsiElement element, String name, TextRange textRange) {
        super(element, textRange);
        this.name = name;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<VASMacroImpl> macros = VASUtil.findMacros(project, name);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (VASMacroImpl macro : macros) {
            results.add(new PsiElementResolveResult(macro));
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
        List<VASMacroImpl> macros = VASUtil.findMacros(project);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final VASMacroImpl macro : macros) {
            if (macro.getName() != null && macro.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(macro).
                                withIcon(VASIcons.FILE).
                                withTypeText(macro.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
