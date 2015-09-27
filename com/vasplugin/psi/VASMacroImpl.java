// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface VASMacroImpl extends VASNamedElement {

  @Nullable
  VASMacroParams getMacroParams();

  @Nullable
  VASValues getValues();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
