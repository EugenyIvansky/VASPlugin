// This is a generated file. Not intended for manual editing.
package com.vasplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.vasplugin.psi.impl.*;

public interface VASTypes {

  IElementType ENTITY = new VASElementType("ENTITY");
  IElementType KEY_VALUE_PAIR = new VASElementType("KEY_VALUE_PAIR");
  IElementType KEY_VALUE_PAIR_LIST = new VASElementType("KEY_VALUE_PAIR_LIST");
  IElementType MACROS = new VASElementType("MACROS");
  IElementType MACRO_IMPL = new VASElementType("MACRO_IMPL");
  IElementType MACRO_PARAMS = new VASElementType("MACRO_PARAMS");
  IElementType SIMPLE_VALUE = new VASElementType("SIMPLE_VALUE");
  IElementType VALUES = new VASElementType("VALUES");

  IElementType B_ENTITY = new VASTokenType("B_ENTITY");
  IElementType B_VALUES = new VASTokenType("B_VALUES");
  IElementType COMMENT = new VASTokenType("COMMENT");
  IElementType CRLF = new VASTokenType("CRLF");
  IElementType E_ENTITY = new VASTokenType("E_ENTITY");
  IElementType E_VALUES = new VASTokenType("E_VALUES");
  IElementType KEY = new VASTokenType("KEY");
  IElementType KV_SEPARATOR = new VASTokenType("KV_SEPARATOR");
  IElementType MACRO_BRACKET_END = new VASTokenType("MACRO_BRACKET_END");
  IElementType MACRO_BRACKET_START = new VASTokenType("MACRO_BRACKET_START");
  IElementType MACRO_CALL = new VASTokenType("MACRO_CALL");
  IElementType MACRO_CALL_PARAMS = new VASTokenType("MACRO_CALL_PARAMS");
  IElementType MACRO_IMPL_END = new VASTokenType("MACRO_IMPL_END");
  IElementType MACRO_IMPL_START = new VASTokenType("MACRO_IMPL_START");
  IElementType MACRO_IMPORT = new VASTokenType("MACRO_IMPORT");
  IElementType MACRO_NAME = new VASTokenType("MACRO_NAME");
  IElementType MACRO_PARAM = new VASTokenType("MACRO_PARAM");
  IElementType SEPARATOR = new VASTokenType("SEPARATOR");
  IElementType VAS_VALUE = new VASTokenType("VAS_VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ENTITY) {
        return new VASEntityImpl(node);
      }
      else if (type == KEY_VALUE_PAIR) {
        return new VASKeyValuePairImpl(node);
      }
      else if (type == KEY_VALUE_PAIR_LIST) {
        return new VASKeyValuePairListImpl(node);
      }
      else if (type == MACROS) {
        return new VASMacrosImpl(node);
      }
      else if (type == MACRO_IMPL) {
        return new VASMacroImplImpl(node);
      }
      else if (type == MACRO_PARAMS) {
        return new VASMacroParamsImpl(node);
      }
      else if (type == SIMPLE_VALUE) {
        return new VASSimpleValueImpl(node);
      }
      else if (type == VALUES) {
        return new VASValuesImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
