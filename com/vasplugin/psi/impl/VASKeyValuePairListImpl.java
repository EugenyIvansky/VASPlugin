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

public class VASKeyValuePairListImpl extends ASTWrapperPsiElement implements VASKeyValuePairList {

  public VASKeyValuePairListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VASVisitor) ((VASVisitor)visitor).visitKeyValuePairList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VASKeyValuePair getKeyValuePair() {
    return findNotNullChildByClass(VASKeyValuePair.class);
  }

  @Override
  @Nullable
  public VASKeyValuePairList getKeyValuePairList() {
    return findChildByClass(VASKeyValuePairList.class);
  }

}
