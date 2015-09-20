// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.vasplugin.psi.VASTypes.*;
import com.vasplugin.psi.*;

public class VASMacroImplImpl extends VASNamedElementImpl implements VASMacroImpl {

  public VASMacroImplImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VASVisitor) ((VASVisitor)visitor).visitMacroImpl(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VASMacroParams getMacroParams() {
    return findChildByClass(VASMacroParams.class);
  }

  @Override
  @Nullable
  public VASValues getValues() {
    return findChildByClass(VASValues.class);
  }

  public String getName() {
    return VASPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return VASPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return VASPsiImplUtil.getNameIdentifier(this);
  }

}
