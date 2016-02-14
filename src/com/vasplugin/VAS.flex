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
KEY=\"[:letter:]+[[:digit:][:letter:]_]*\" | ([:digit:])+ | [[:digit:][:letter:]_]+
VALUE=\"~([^\\]\") | [:digit:]+([,.][:digit:]+)? | '[:letter:]' | [[:digit:][:letter:]_]+

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

<YYINITIAL> {KEY}                                           { return VASTypes.KEY; }
<WAITING_VALUE> {VALUE}                                     { yybegin(YYINITIAL); return VASTypes.VAS_VALUE; }
<WAITING_VALUES> {VALUE}                                    { yybegin(WAITING_VALUES); return VASTypes.VAS_VALUE; }

{MACRO_IMPORT}                                              { return VASTypes.MACRO_IMPORT; }

{MACRO_IMPL_START}                                          { yybegin(WAITING_MACRO_NAME); return VASTypes.MACRO_IMPL_START; }
<WAITING_MACRO_NAME> [(]                                    { return VASTypes.MACRO_BRACKET_START; }
<WAITING_MACRO_NAME> {MACRO_NAME}                           { yybegin(WAITING_MACRO_BRACKET_END); return VASTypes.MACRO_NAME; }
<WAITING_MACRO_BRACKET_END> [$][[:digit:][:letter:]_]+      { return VASTypes.MACRO_PARAM; }
<WAITING_MACRO_BRACKET_END> [)]                             { yybegin(WAITING_MACRO_IMPL); return VASTypes.MACRO_BRACKET_END; }
{MACRO_IMPL_END}                                            { yybegin(YYINITIAL); return VASTypes.MACRO_IMPL_END; }

{MACRO_CALL}                                                { yybegin(END_MACRO); return VASTypes.MACRO_CALL; }
<END_MACRO> {MACRO_CALL_PARAMS}                             { return VASTypes.MACRO_CALL_PARAMS; }

{B_ENTITY}                                                  { yybegin(YYINITIAL); return VASTypes.B_ENTITY; }
{E_ENTITY}                                                  { yybegin(YYINITIAL); return VASTypes.E_ENTITY; }
{B_VALUES}                                                  { yybegin(WAITING_VALUES); return VASTypes.B_VALUES; }
{E_VALUES}                                                  { yybegin(YYINITIAL); return VASTypes.E_VALUES; }
<WAITING_VALUES> {SEPARATOR}                                { yybegin(WAITING_VALUES); return VASTypes.SEPARATOR; }
{SEPARATOR}                                                 { yybegin(YYINITIAL); return VASTypes.SEPARATOR; }
{KV_SEPARATOR}                                              { yybegin(WAITING_VALUE); return VASTypes.KV_SEPARATOR; }

{COMMENTS}                                                  { return VASTypes.COMMENT; }
{CRLF}                                                      { return VASTypes.CRLF; }
{WHITE_SPACE}+                                              { return TokenType.WHITE_SPACE; }
.                                                           { return TokenType.BAD_CHARACTER; }