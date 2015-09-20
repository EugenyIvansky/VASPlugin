package com.vasplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceService;
import com.intellij.psi.tree.IElementType;
import com.vasplugin.psi.*;
import com.vasplugin.psi.VASEntity;
import com.vasplugin.psi.VASMacroImpl;
import com.vasplugin.psi.VASMacros;
import com.vasplugin.psi.VASTypes;
import org.jetbrains.annotations.NotNull;

public class VASPsiImplUtil {
    public static String getName(VASMacroImpl element) {
        ASTNode macroNameNode = element.getNode().findChildByType(VASTypes.MACRO_NAME);
        if (macroNameNode != null) {
            return macroNameNode.getText();
        } else {
            return null;
        }
    }

    public static PsiElement setName(VASMacroImpl element, String newName) {
        ASTNode macroNameNode = element.getNode().findChildByType(VASTypes.MACRO_NAME);

        if (macroNameNode != null) {
            VASMacroImpl macro = VASElementFactory.createMacroImpl(element.getProject(), newName);
            ASTNode newMacroNameNode = macro.getNode().findChildByType(VASTypes.MACRO_NAME);
            element.getNode().replaceChild(macroNameNode, newMacroNameNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(VASMacroImpl element) {
        ASTNode macroNameNode = element.getNode().findChildByType(VASTypes.MACRO_NAME);
        if (macroNameNode != null) {
            return macroNameNode.getPsi();
        } else {
            return null;
        }
    }

    public static String getName(VASMacros element) {
        ASTNode macroNameNode = element.getNode().findChildByType(VASTypes.MACRO_CALL);
        if (macroNameNode != null) {
            return macroNameNode.getText().substring(1);
        } else {
            return null;
        }
    }

    public static PsiElement setName(VASMacros element, String newName) {
        ASTNode macroCallNode = element.getNode().findChildByType(VASTypes.MACRO_CALL);

        if (macroCallNode != null) {
            VASMacros macro = VASElementFactory.createMacros(element.getProject(), newName);
            ASTNode newMacroCallNode = macro.getNode().findChildByType(VASTypes.MACRO_CALL);
            element.getNode().replaceChild(macroCallNode, newMacroCallNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(VASMacros element) {
        ASTNode macroNameNode = element.getNode().findChildByType(VASTypes.MACRO_CALL);
        if (macroNameNode != null) {
            return macroNameNode.getPsi();
        } else {
            return null;
        }
    }

    public static String getName(VASEntity element) {
        ASTNode kvPair = getIDKVPair(element);
        if (kvPair != null) {
            ASTNode value = kvPair.findChildByType(VASTypes.SIMPLE_VALUE);
            if (value != null) {
                return value.getText().substring(1, value.getText().length() - 1);
            }
        }
        return null;
    }

    public static PsiElement setName(VASEntity element, String newName) {
        ASTNode kvPair = getIDKVPair(element);
        if (kvPair != null) {
            ASTNode value = kvPair.findChildByType(VASTypes.SIMPLE_VALUE);
            if (value != null) {
                VASEntity entity = VASElementFactory.createEntity(element.getProject(), newName);
                ASTNode newValue = entity.getNode().findChildByType(VASTypes.KEY_VALUE_PAIR_LIST).findChildByType(VASTypes.KEY_VALUE_PAIR).findChildByType(VASTypes.SIMPLE_VALUE);
                kvPair.replaceChild(value, newValue);
            }
        }
        return element;
    }

    public static PsiElement getNameIdentifier(VASEntity element) {
        ASTNode kvPair = getIDKVPair(element);
        if (kvPair != null) {
            return kvPair.getPsi();
        } else {
            return null;
        }
    }

    private static ASTNode getIDKVPair(VASEntity element){
        ASTNode kvList = element.getNode().findChildByType(VASTypes.KEY_VALUE_PAIR_LIST);
        if (kvList != null) {
            ASTNode kvPair = kvList.findChildByType(VASTypes.KEY_VALUE_PAIR);
            while (kvPair != null){
                ASTNode key = kvPair.findChildByType(VASTypes.KEY);
                if(key != null && key.getText().substring(1, key.getText().length() - 1).equals("id")){
                    return kvPair;
                } else {
                    kvPair = null;
                    kvList = kvList.findChildByType(VASTypes.KEY_VALUE_PAIR_LIST);
                    if (kvList != null) {
                        kvPair = kvList.findChildByType(VASTypes.KEY_VALUE_PAIR);
                    }
                }
            }
        }
        return null;
    }
}