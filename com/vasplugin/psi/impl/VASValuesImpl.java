// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.vasplugin.psi.VASTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vasplugin.psi.*;

public class VASValuesImpl extends ASTWrapperPsiElement implements VASValues {

  public VASValuesImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VASVisitor) ((VASVisitor)visitor).visitValues(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VASMacros getMacros() {
    return findChildByClass(VASMacros.class);
  }

  @Override
  @Nullable
  public VASSimpleValue getSimpleValue() {
    return findChildByClass(VASSimpleValue.class);
  }

  @Override
  @Nullable
  public VASEntity getEntity() {
    return findChildByClass(VASEntity.class);
  }

  @Override
  @Nullable
  public VASKeyValuePair getKeyValuePair() {
    return findChildByClass(VASKeyValuePair.class);
  }

  @Override
  @Nullable
  public VASValues getValues() {
    return findChildByClass(VASValues.class);
  }

}
