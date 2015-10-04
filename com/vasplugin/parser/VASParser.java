// This is a generated file. Not intended for manual editing.
package com.vasplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.vasplugin.psi.VASTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class VASParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == MACROS) {
      r = MACROS(b, 0);
    }
    else if (t == MACRO_IMPL) {
      r = MACRO_IMPL(b, 0);
    }
    else if (t == MACRO_PARAMS) {
      r = MACRO_PARAMS(b, 0);
    }
    else if (t == SIMPLE_VALUE) {
      r = SIMPLE_VALUE(b, 0);
    }
    else if (t == ENTITY) {
      r = entity(b, 0);
    }
    else if (t == KEY_VALUE_PAIR) {
      r = key_value_pair(b, 0);
    }
    else if (t == KEY_VALUE_PAIR_LIST) {
      r = key_value_pair_list(b, 0);
    }
    else if (t == VALUES) {
      r = values(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return vasFile(b, l + 1);
  }

  /* ********************************************************** */
  // MACRO_CALL MACRO_CALL_PARAMS?
  public static boolean MACROS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACROS")) return false;
    if (!nextTokenIs(b, MACRO_CALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MACRO_CALL);
    r = r && MACROS_1(b, l + 1);
    exit_section_(b, m, MACROS, r);
    return r;
  }

  // MACRO_CALL_PARAMS?
  private static boolean MACROS_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACROS_1")) return false;
    consumeToken(b, MACRO_CALL_PARAMS);
    return true;
  }

  /* ********************************************************** */
  // MACRO_IMPL_START MACRO_BRACKET_START MACRO_NAME MACRO_PARAMS? MACRO_BRACKET_END values? MACRO_IMPL_END
  public static boolean MACRO_IMPL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_IMPL")) return false;
    if (!nextTokenIs(b, MACRO_IMPL_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MACRO_IMPL_START, MACRO_BRACKET_START, MACRO_NAME);
    r = r && MACRO_IMPL_3(b, l + 1);
    r = r && consumeToken(b, MACRO_BRACKET_END);
    r = r && MACRO_IMPL_5(b, l + 1);
    r = r && consumeToken(b, MACRO_IMPL_END);
    exit_section_(b, m, MACRO_IMPL, r);
    return r;
  }

  // MACRO_PARAMS?
  private static boolean MACRO_IMPL_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_IMPL_3")) return false;
    MACRO_PARAMS(b, l + 1);
    return true;
  }

  // values?
  private static boolean MACRO_IMPL_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_IMPL_5")) return false;
    values(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MACRO_PARAM MACRO_PARAMS?
  public static boolean MACRO_PARAMS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_PARAMS")) return false;
    if (!nextTokenIs(b, MACRO_PARAM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MACRO_PARAM);
    r = r && MACRO_PARAMS_1(b, l + 1);
    exit_section_(b, m, MACRO_PARAMS, r);
    return r;
  }

  // MACRO_PARAMS?
  private static boolean MACRO_PARAMS_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MACRO_PARAMS_1")) return false;
    MACRO_PARAMS(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (VAS_VALUE)
  public static boolean SIMPLE_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIMPLE_VALUE")) return false;
    if (!nextTokenIs(b, VAS_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAS_VALUE);
    exit_section_(b, m, SIMPLE_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // B_ENTITY key_value_pair_list? E_ENTITY
  public static boolean entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity")) return false;
    if (!nextTokenIs(b, B_ENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, B_ENTITY);
    r = r && entity_1(b, l + 1);
    r = r && consumeToken(b, E_ENTITY);
    exit_section_(b, m, ENTITY, r);
    return r;
  }

  // key_value_pair_list?
  private static boolean entity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_1")) return false;
    key_value_pair_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // entity | MACRO_IMPORT | MACRO_IMPL | MACROS | COMMENT | CRLF | values
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity(b, l + 1);
    if (!r) r = consumeToken(b, MACRO_IMPORT);
    if (!r) r = MACRO_IMPL(b, l + 1);
    if (!r) r = MACROS(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = values(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY  KV_SEPARATOR (SIMPLE_VALUE|entity)) | (KEY KV_SEPARATOR B_VALUES values? E_VALUES) | (KEY) | (MACROS)
  public static boolean key_value_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair")) return false;
    if (!nextTokenIs(b, "<key value pair>", KEY, MACRO_CALL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key value pair>");
    r = key_value_pair_0(b, l + 1);
    if (!r) r = key_value_pair_1(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    if (!r) r = key_value_pair_3(b, l + 1);
    exit_section_(b, l, m, KEY_VALUE_PAIR, r, false, null);
    return r;
  }

  // KEY  KV_SEPARATOR (SIMPLE_VALUE|entity)
  private static boolean key_value_pair_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, KV_SEPARATOR);
    r = r && key_value_pair_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SIMPLE_VALUE|entity
  private static boolean key_value_pair_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SIMPLE_VALUE(b, l + 1);
    if (!r) r = entity(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY KV_SEPARATOR B_VALUES values? E_VALUES
  private static boolean key_value_pair_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, KV_SEPARATOR, B_VALUES);
    r = r && key_value_pair_1_3(b, l + 1);
    r = r && consumeToken(b, E_VALUES);
    exit_section_(b, m, null, r);
    return r;
  }

  // values?
  private static boolean key_value_pair_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_1_3")) return false;
    values(b, l + 1);
    return true;
  }

  // (MACROS)
  private static boolean key_value_pair_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MACROS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (key_value_pair SEPARATOR key_value_pair_list) | (key_value_pair)
  public static boolean key_value_pair_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_list")) return false;
    if (!nextTokenIs(b, "<key value pair list>", KEY, MACRO_CALL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key value pair list>");
    r = key_value_pair_list_0(b, l + 1);
    if (!r) r = key_value_pair_list_1(b, l + 1);
    exit_section_(b, l, m, KEY_VALUE_PAIR_LIST, r, false, null);
    return r;
  }

  // key_value_pair SEPARATOR key_value_pair_list
  private static boolean key_value_pair_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_value_pair(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && key_value_pair_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (key_value_pair)
  private static boolean key_value_pair_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_pair_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_value_pair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((SIMPLE_VALUE|entity|key_value_pair|MACROS|(B_VALUES values? E_VALUES)) SEPARATOR values) | (SIMPLE_VALUE|entity|key_value_pair|MACROS|(B_VALUES values? E_VALUES))
  public static boolean values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<values>");
    r = values_0(b, l + 1);
    if (!r) r = values_1(b, l + 1);
    exit_section_(b, l, m, VALUES, r, false, null);
    return r;
  }

  // (SIMPLE_VALUE|entity|key_value_pair|MACROS|(B_VALUES values? E_VALUES)) SEPARATOR values
  private static boolean values_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = values_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && values(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SIMPLE_VALUE|entity|key_value_pair|MACROS|(B_VALUES values? E_VALUES)
  private static boolean values_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SIMPLE_VALUE(b, l + 1);
    if (!r) r = entity(b, l + 1);
    if (!r) r = key_value_pair(b, l + 1);
    if (!r) r = MACROS(b, l + 1);
    if (!r) r = values_0_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // B_VALUES values? E_VALUES
  private static boolean values_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_0_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, B_VALUES);
    r = r && values_0_0_4_1(b, l + 1);
    r = r && consumeToken(b, E_VALUES);
    exit_section_(b, m, null, r);
    return r;
  }

  // values?
  private static boolean values_0_0_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_0_0_4_1")) return false;
    values(b, l + 1);
    return true;
  }

  // SIMPLE_VALUE|entity|key_value_pair|MACROS|(B_VALUES values? E_VALUES)
  private static boolean values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SIMPLE_VALUE(b, l + 1);
    if (!r) r = entity(b, l + 1);
    if (!r) r = key_value_pair(b, l + 1);
    if (!r) r = MACROS(b, l + 1);
    if (!r) r = values_1_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // B_VALUES values? E_VALUES
  private static boolean values_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_1_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, B_VALUES);
    r = r && values_1_4_1(b, l + 1);
    r = r && consumeToken(b, E_VALUES);
    exit_section_(b, m, null, r);
    return r;
  }

  // values?
  private static boolean values_1_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_1_4_1")) return false;
    values(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // item_*
  static boolean vasFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vasFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vasFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}
