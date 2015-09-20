// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class VASVisitor extends PsiElementVisitor {

  public void visitMacros(@NotNull VASMacros o) {
    visitContributedReferenceHost(o);
  }

  public void visitMacroImpl(@NotNull VASMacroImpl o) {
    visitNamedElement(o);
  }

  public void visitMacroParams(@NotNull VASMacroParams o) {
    visitPsiElement(o);
  }

  public void visitSimpleValue(@NotNull VASSimpleValue o) {
    visitContributedReferenceHost(o);
  }

  public void visitEntity(@NotNull VASEntity o) {
    visitNamedElement(o);
  }

  public void visitKeyValuePair(@NotNull VASKeyValuePair o) {
    visitContributedReferenceHost(o);
  }

  public void visitKeyValuePairList(@NotNull VASKeyValuePairList o) {
    visitPsiElement(o);
  }

  public void visitValues(@NotNull VASValues o) {
    visitPsiElement(o);
  }

  public void visitContributedReferenceHost(@NotNull VASContributedReferenceHost o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull VASNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
