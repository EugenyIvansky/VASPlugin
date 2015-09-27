package com.vasplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.vasplugin.psi.VASTypes;
import com.intellij.psi.TokenType;

%%

%class VASLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE= {CRLF} | [\ \t\f]
COMMENTS= "#*" ~"*#"
SEPARATOR= [,]
KV_SEPARATOR= [:]
B_ENTITY= [{]
E_ENTITY= [}]
B_VALUES= [(]
E_VALUES= [)]
MACRO_IMPORT= "#parse" ~")"
MACRO_IMPL_START= [#]macro
MACRO_NAME=[[:digit:][:letter:]_]+
MACRO_IMPL_END= [#]end
MACRO_CALL= [#][[:digit:][:letter:]_']+
MACRO_CALL_PARAMS= [(].*[)]
KEY=\"[:letter:]+[[:digit:][:letter:]_]*\"
VALUE=\"~([^\\]\") | [:digit:]+([,.][:digit:]+)? | '[:letter:]' | [:letter:]+

%state WAITING_ENTITY
%state WAITING_KV_PAIR
%state WAITING_KV_SEPARATOR
%state WAITING_VALUE
%state WAITING_VALUES
%state END_ENTITY
%state END_KEY_VALUE_PAIR
%state WAITING_MACRO_NAME
%state WAITING_MACRO_IMPL
%state WAITING_MACRO_BRACKET_END
%state END_MACRO

%%

<YYINITIAL, WAITING_ENTITY, WAITING_MACRO_IMPL> {B_ENTITY}  { yybegin(WAITING_KV_PAIR); return VASTypes.B_ENTITY; }

<WAITING_KV_PAIR> {E_ENTITY} { yybegin(END_ENTITY); return VASTypes.E_ENTITY; }
<WAITING_KV_PAIR> {E_VALUES} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.E_VALUES; }
<WAITING_KV_PAIR> {KEY} { yybegin(WAITING_KV_SEPARATOR); return VASTypes.KEY; }

<WAITING_KV_SEPARATOR> {KV_SEPARATOR} { yybegin(WAITING_VALUE); return VASTypes.KV_SEPARATOR; }
<WAITING_KV_SEPARATOR> {SEPARATOR} { yybegin(WAITING_KV_PAIR); return VASTypes.SEPARATOR; }
<WAITING_KV_SEPARATOR> {E_ENTITY} { yybegin(END_ENTITY); return VASTypes.E_ENTITY; }
<WAITING_KV_SEPARATOR> {E_VALUES} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.E_VALUES; }

<WAITING_VALUE> {B_ENTITY}  { yybegin(WAITING_KV_PAIR); return VASTypes.B_ENTITY; }
<WAITING_VALUE> {VALUE} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.VAS_VALUE; }
<YYINITIAL, WAITING_VALUE> {B_VALUES} { yybegin(WAITING_VALUES); return VASTypes.B_VALUES; }

<WAITING_VALUES> {B_ENTITY}  { yybegin(WAITING_KV_PAIR); return VASTypes.B_ENTITY; }
<WAITING_VALUES> {KEY} { yybegin(WAITING_KV_SEPARATOR); return VASTypes.KEY; }
<WAITING_VALUES> {E_VALUES} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.E_VALUES; }

<END_ENTITY> {SEPARATOR} { yybegin(WAITING_ENTITY); return VASTypes.SEPARATOR; }
<END_ENTITY> {E_VALUES} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.E_VALUES; }
<END_KEY_VALUE_PAIR> {SEPARATOR} { yybegin(WAITING_KV_PAIR); return VASTypes.SEPARATOR; }
<END_KEY_VALUE_PAIR> {E_VALUES} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.E_VALUES; }
<END_KEY_VALUE_PAIR> {E_ENTITY} { yybegin(END_ENTITY); return VASTypes.E_ENTITY; }

<END_MACRO> {SEPARATOR} { yybegin(WAITING_ENTITY); return VASTypes.SEPARATOR; }
<END_MACRO> {E_VALUES} { yybegin(END_KEY_VALUE_PAIR); return VASTypes.E_VALUES; }
<END_MACRO> {E_ENTITY} { yybegin(END_ENTITY); return VASTypes.E_ENTITY; }

{MACRO_IMPORT}                                              { return VASTypes.MACRO_IMPORT; }

{MACRO_IMPL_START}                                          { yybegin(WAITING_MACRO_NAME); return VASTypes.MACRO_IMPL_START; }
<WAITING_MACRO_NAME> [(]                                    { return VASTypes.MACRO_BRACKET_START; }
<WAITING_MACRO_NAME> {MACRO_NAME}                           { yybegin(WAITING_MACRO_BRACKET_END); return VASTypes.MACRO_NAME; }
<WAITING_MACRO_BRACKET_END> [$][[:digit:][:letter:]_]+      { return VASTypes.MACRO_PARAM; }
<WAITING_MACRO_BRACKET_END> [)]                             { yybegin(WAITING_MACRO_IMPL); return VASTypes.MACRO_BRACKET_END; }
{MACRO_IMPL_END}                                            { yybegin(YYINITIAL); return VASTypes.MACRO_IMPL_END; }

{MACRO_CALL}                                                { yybegin(END_MACRO); return VASTypes.MACRO_CALL; }
<END_MACRO> {MACRO_CALL_PARAMS}                             { return VASTypes.MACRO_CALL_PARAMS; }

{COMMENTS}                                                  { return VASTypes.COMMENT; }
{CRLF}                                                      { return VASTypes.CRLF; }
{WHITE_SPACE}+                                              { return TokenType.WHITE_SPACE; }
.                                                           { return TokenType.BAD_CHARACTER; }