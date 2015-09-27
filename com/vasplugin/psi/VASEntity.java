// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface VASEntity extends VASNamedElement {

  @Nullable
  VASKeyValuePairList getKeyValuePairList();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
