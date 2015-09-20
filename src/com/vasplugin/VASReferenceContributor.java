package com.vasplugin;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.vasplugin.psi.VASKeyValuePair;
import com.vasplugin.psi.VASMacros;
import com.vasplugin.psi.VASSimpleValue;
import com.vasplugin.psi.VASTypes;
import org.jetbrains.annotations.NotNull;

public class VASReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(VASMacros.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        VASMacros macroCall = (VASMacros) element;
                        String macroName = macroCall.getName();
                        if (macroName != null) {
                            return new PsiReference[]{new VASMacroReference(element, macroName, new TextRange(1, macroName.length() + 1))};
                        }
                        return new PsiReference[0];
                    }
                });

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(VASSimpleValue.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        VASSimpleValue value = (VASSimpleValue) element;
                        if (VASKeyValuePair.class.isInstance(value.getParent())) {
                            VASKeyValuePair kvPair = (VASKeyValuePair) value.getParent();
                            ASTNode key = kvPair.getNode().findChildByType(VASTypes.KEY);
                            if (key != null) {
                                String keyName = key.getText().substring(1, key.getText().length() - 1);
                                if (keyName.equals("baseRef") || keyName.equals("inputRef") || keyName.equals("name")) {
                                    String valueName = value.getText().substring(1, value.getText().length() - 1);
                                    return new PsiReference[]{new VASEntityReference(value, valueName, new TextRange(1, valueName.length() + 1))};
                                }
                            }
                        }

                        return new PsiReference[0];
                    }
                });
    }
}

