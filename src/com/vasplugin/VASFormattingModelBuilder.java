package com.vasplugin;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.vasplugin.psi.VASTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VASFormattingModelBuilder implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
                new VASBlock(element.getNode(), Wrap.createWrap(WrapType.NONE, false),
                        Alignment.createAlignment(true), createSpaceBuilder(settings)), settings);
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, VASLanguage.INSTANCE).
                before(VASTypes.ENTITY).lineBreakInCodeIf(true).
//                after(VASTypes.B_VALUES).lineBreakInCodeIf(true).
//                before(VASTypes.E_VALUES).lineBreakInCodeIf(true).
                after(VASTypes.SEPARATOR).spaceIf(settings.SPACE_AFTER_COMMA).
                before(VASTypes.SEPARATOR).spaceIf(settings.SPACE_BEFORE_COMMA).
                after(VASTypes.KV_SEPARATOR).spaceIf(settings.SPACE_AFTER_SEMICOLON).
                before(VASTypes.KV_SEPARATOR).spaceIf(settings.SPACE_BEFORE_SEMICOLON);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}

