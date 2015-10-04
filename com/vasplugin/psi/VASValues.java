// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VASValues extends PsiElement {

  @Nullable
  VASMacros getMacros();

  @Nullable
  VASSimpleValue getSimpleValue();

  @Nullable
  VASEntity getEntity();

  @Nullable
  VASKeyValuePair getKeyValuePair();

  @NotNull
  List<VASValues> getValuesList();

}
