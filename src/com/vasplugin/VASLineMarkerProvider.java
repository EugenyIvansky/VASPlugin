package com.vasplugin;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.vasplugin.psi.VASMacroImpl;
import com.vasplugin.psi.VASMacros;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class VASLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof VASMacros) {
            VASMacros macro = (VASMacros) element;
            String macroName = macro.getName();
            if (macroName == null) {
                return;
            }

            final List<VASMacroImpl> macros = VASUtil.findMacros(element.getProject(), macroName);
            if (macros.size() > 0) {
                NavigationGutterIconBuilder<PsiElement> builder = NavigationGutterIconBuilder.create(VASIcons.MACRO)
                        .setTargets(macros)
                        .setTooltipText("Navigate to a macros");
                result.add(builder.createLineMarkerInfo(element));
            }
        }
    }
}