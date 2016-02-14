/* The following code was generated by JFlex 1.4.3 on 06.10.15 22:19 */

package com.vasplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.vasplugin.psi.VASTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 06.10.15 22:19 from the specification file
 * <tt>C:/Users/Evgeny/IdeaProjects/VASPlugin/src/com/vasplugin/VAS.flex</tt>
 */
class VASLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int WAITING_VALUE = 8;
  public static final int WAITING_MACRO_NAME = 16;
  public static final int END_KEY_VALUE_PAIR = 14;
  public static final int WAITING_MACRO_BRACKET_END = 20;
  public static final int WAITING_KV_PAIR = 4;
  public static final int WAITING_VALUES = 10;
  public static final int END_ENTITY = 12;
  public static final int YYINITIAL = 0;
  public static final int END_MACRO = 22;
  public static final int WAITING_MACRO_IMPL = 18;
  public static final int WAITING_ENTITY = 2;
  public static final int WAITING_KV_SEPARATOR = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  1,  1,  1,  1,  2,  2,  3,  3,  1,  1,  1,  1, 
     4,  4,  1,  1,  5,  5,  6, 6
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\1\1\0\1\3\1\2\22\0\1\3\1\0\1\30"+
    "\1\4\1\35\2\0\1\27\1\12\1\13\1\5\1\0\1\6\1\0"+
    "\1\34\1\0\12\32\1\7\6\0\32\31\1\0\1\33\2\0\1\24"+
    "\1\0\1\15\1\31\1\22\1\26\1\20\7\31\1\21\1\25\1\23"+
    "\1\14\1\31\1\16\1\17\7\31\1\10\1\0\1\11\54\0\1\31"+
    "\12\0\1\31\4\0\1\31\5\0\27\31\1\0\37\31\1\0\u01ca\31"+
    "\4\0\14\31\16\0\5\31\7\0\1\31\1\0\1\31\201\0\5\31"+
    "\1\0\2\31\2\0\4\31\10\0\1\31\1\0\3\31\1\0\1\31"+
    "\1\0\24\31\1\0\123\31\1\0\213\31\10\0\236\31\11\0\46\31"+
    "\2\0\1\31\7\0\47\31\110\0\33\31\5\0\3\31\55\0\53\31"+
    "\25\0\12\32\4\0\2\31\1\0\143\31\1\0\1\31\17\0\2\31"+
    "\7\0\2\31\12\32\3\31\2\0\1\31\20\0\1\31\1\0\36\31"+
    "\35\0\131\31\13\0\1\31\16\0\12\32\41\31\11\0\2\31\4\0"+
    "\1\31\5\0\26\31\4\0\1\31\11\0\1\31\3\0\1\31\27\0"+
    "\31\31\107\0\1\31\1\0\13\31\127\0\66\31\3\0\1\31\22\0"+
    "\1\31\7\0\12\31\4\0\12\32\1\0\7\31\1\0\7\31\5\0"+
    "\10\31\2\0\2\31\2\0\26\31\1\0\7\31\1\0\1\31\3\0"+
    "\4\31\3\0\1\31\20\0\1\31\15\0\2\31\1\0\3\31\4\0"+
    "\12\32\2\31\23\0\6\31\4\0\2\31\2\0\26\31\1\0\7\31"+
    "\1\0\2\31\1\0\2\31\1\0\2\31\37\0\4\31\1\0\1\31"+
    "\7\0\12\32\2\0\3\31\20\0\11\31\1\0\3\31\1\0\26\31"+
    "\1\0\7\31\1\0\2\31\1\0\5\31\3\0\1\31\22\0\1\31"+
    "\17\0\2\31\4\0\12\32\25\0\10\31\2\0\2\31\2\0\26\31"+
    "\1\0\7\31\1\0\2\31\1\0\5\31\3\0\1\31\36\0\2\31"+
    "\1\0\3\31\4\0\12\32\1\0\1\31\21\0\1\31\1\0\6\31"+
    "\3\0\3\31\1\0\4\31\3\0\2\31\1\0\1\31\1\0\2\31"+
    "\3\0\2\31\3\0\3\31\3\0\14\31\26\0\1\31\25\0\12\32"+
    "\25\0\10\31\1\0\3\31\1\0\27\31\1\0\12\31\1\0\5\31"+
    "\3\0\1\31\32\0\2\31\6\0\2\31\4\0\12\32\25\0\10\31"+
    "\1\0\3\31\1\0\27\31\1\0\12\31\1\0\5\31\3\0\1\31"+
    "\40\0\1\31\1\0\2\31\4\0\12\32\1\0\2\31\22\0\10\31"+
    "\1\0\3\31\1\0\51\31\2\0\1\31\20\0\1\31\21\0\2\31"+
    "\4\0\12\32\12\0\6\31\5\0\22\31\3\0\30\31\1\0\11\31"+
    "\1\0\1\31\2\0\7\31\72\0\60\31\1\0\2\31\14\0\7\31"+
    "\11\0\12\32\47\0\2\31\1\0\1\31\2\0\2\31\1\0\1\31"+
    "\2\0\1\31\6\0\4\31\1\0\7\31\1\0\3\31\1\0\1\31"+
    "\1\0\1\31\2\0\2\31\1\0\4\31\1\0\2\31\11\0\1\31"+
    "\2\0\5\31\1\0\1\31\11\0\12\32\2\0\4\31\40\0\1\31"+
    "\37\0\12\32\26\0\10\31\1\0\44\31\33\0\5\31\163\0\53\31"+
    "\24\0\1\31\12\32\6\0\6\31\4\0\4\31\3\0\1\31\3\0"+
    "\2\31\7\0\3\31\4\0\15\31\14\0\1\31\1\0\12\32\6\0"+
    "\46\31\1\0\1\31\5\0\1\31\2\0\53\31\1\0\u014d\31\1\0"+
    "\4\31\2\0\7\31\1\0\1\31\1\0\4\31\2\0\51\31\1\0"+
    "\4\31\2\0\41\31\1\0\4\31\2\0\7\31\1\0\1\31\1\0"+
    "\4\31\2\0\17\31\1\0\71\31\1\0\4\31\2\0\103\31\45\0"+
    "\20\31\20\0\125\31\14\0\u026c\31\2\0\21\31\1\0\32\31\5\0"+
    "\113\31\25\0\15\31\1\0\4\31\16\0\22\31\16\0\22\31\16\0"+
    "\15\31\1\0\3\31\17\0\64\31\43\0\1\31\4\0\1\31\3\0"+
    "\12\32\46\0\12\32\6\0\130\31\10\0\51\31\1\0\1\31\5\0"+
    "\106\31\12\0\35\31\51\0\12\32\36\31\2\0\5\31\13\0\54\31"+
    "\25\0\7\31\10\0\12\32\46\0\27\31\11\0\65\31\53\0\12\32"+
    "\6\0\12\32\15\0\1\31\135\0\57\31\21\0\7\31\4\0\12\32"+
    "\51\0\36\31\15\0\2\31\12\32\54\31\32\0\44\31\34\0\12\32"+
    "\3\0\3\31\12\32\44\31\153\0\4\31\1\0\4\31\3\0\2\31"+
    "\11\0\300\31\100\0\u0116\31\2\0\6\31\2\0\46\31\2\0\6\31"+
    "\2\0\10\31\1\0\1\31\1\0\1\31\1\0\1\31\1\0\37\31"+
    "\2\0\65\31\1\0\7\31\1\0\1\31\3\0\3\31\1\0\7\31"+
    "\3\0\4\31\2\0\6\31\4\0\15\31\5\0\3\31\1\0\7\31"+
    "\164\0\1\31\15\0\1\31\20\0\15\31\145\0\1\31\4\0\1\31"+
    "\2\0\12\31\1\0\1\31\3\0\5\31\6\0\1\31\1\0\1\31"+
    "\1\0\1\31\1\0\4\31\1\0\13\31\2\0\4\31\5\0\5\31"+
    "\4\0\1\31\64\0\2\31\u0a7b\0\57\31\1\0\57\31\1\0\205\31"+
    "\6\0\4\31\3\0\2\31\14\0\46\31\1\0\1\31\5\0\1\31"+
    "\2\0\70\31\7\0\1\31\20\0\27\31\11\0\7\31\1\0\7\31"+
    "\1\0\7\31\1\0\7\31\1\0\7\31\1\0\7\31\1\0\7\31"+
    "\1\0\7\31\120\0\1\31\u01d5\0\2\31\52\0\5\31\5\0\2\31"+
    "\4\0\126\31\6\0\3\31\1\0\132\31\1\0\4\31\5\0\51\31"+
    "\3\0\136\31\21\0\33\31\65\0\20\31\u0200\0\u19b6\31\112\0\u51cd\31"+
    "\63\0\u048d\31\103\0\56\31\2\0\u010d\31\3\0\20\31\12\32\2\31"+
    "\24\0\57\31\20\0\31\31\10\0\106\31\61\0\11\31\2\0\147\31"+
    "\2\0\4\31\1\0\4\31\14\0\13\31\115\0\12\31\1\0\3\31"+
    "\1\0\4\31\1\0\27\31\35\0\64\31\16\0\62\31\34\0\12\32"+
    "\30\0\6\31\3\0\1\31\4\0\12\32\34\31\12\0\27\31\31\0"+
    "\35\31\7\0\57\31\34\0\1\31\12\32\46\0\51\31\27\0\3\31"+
    "\1\0\10\31\4\0\12\32\6\0\27\31\3\0\1\31\5\0\60\31"+
    "\1\0\1\31\3\0\2\31\2\0\5\31\2\0\1\31\1\0\1\31"+
    "\30\0\3\31\2\0\13\31\7\0\3\31\14\0\6\31\2\0\6\31"+
    "\2\0\6\31\11\0\7\31\1\0\7\31\221\0\43\31\15\0\12\32"+
    "\6\0\u2ba4\31\14\0\27\31\4\0\61\31\u2104\0\u016e\31\2\0\152\31"+
    "\46\0\7\31\14\0\5\31\5\0\1\31\1\0\12\31\1\0\15\31"+
    "\1\0\5\31\1\0\1\31\1\0\2\31\1\0\2\31\1\0\154\31"+
    "\41\0\u016b\31\22\0\100\31\2\0\66\31\50\0\14\31\164\0\5\31"+
    "\1\0\207\31\23\0\12\32\7\0\32\31\6\0\32\31\13\0\131\31"+
    "\3\0\6\31\2\0\6\31\2\0\6\31\2\0\3\31\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\1\1\2\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\1\1\13\2\1\1\13"+
    "\1\14\1\15\2\1\1\15\1\16\1\17\1\20\1\1"+
    "\1\10\1\0\4\21\11\0\1\22\1\0\1\23\1\0"+
    "\3\21\1\12\3\13\3\15\1\24\1\21\1\25\4\21"+
    "\1\26\1\0\1\27";

  private static int [] zzUnpackAction() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\36\0\74\0\132\0\170\0\226\0\264\0\322"+
    "\0\360\0\u010e\0\360\0\u012c\0\322\0\322\0\322\0\322"+
    "\0\322\0\322\0\u014a\0\u0168\0\u0186\0\u01a4\0\u01c2\0\u01e0"+
    "\0\322\0\u01fe\0\u021c\0\u023a\0\u0258\0\322\0\u0276\0\322"+
    "\0\u0294\0\u02b2\0\u02d0\0\u02ee\0\u030c\0\u032a\0\u0348\0\u0366"+
    "\0\u0384\0\u03a2\0\u01c2\0\u03c0\0\u03de\0\u03fc\0\u023a\0\u041a"+
    "\0\u0294\0\u02b2\0\u02b2\0\u0438\0\u0456\0\u0474\0\u0492\0\322"+
    "\0\322\0\u04b0\0\u03c0\0\322\0\u04ce\0\u041a\0\322\0\u04ec"+
    "\0\u030c\0\u050a\0\u0528\0\u0546\0\u0564\0\u030c\0\u0582\0\322";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\10\1\11\1\12\1\13\1\14\1\10\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\13\23\1\10\1\24\2\23"+
    "\4\10\1\11\1\12\1\13\1\14\1\10\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\23\10\1\11\1\12\1\13"+
    "\1\14\1\10\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\13\25\1\26\1\27\1\25\1\30\4\10\1\11\1\12"+
    "\1\13\1\14\1\10\1\31\1\16\1\17\1\20\1\21"+
    "\1\22\13\32\1\33\1\34\1\32\1\35\4\10\1\11"+
    "\1\12\1\13\1\14\1\10\1\15\1\16\1\17\1\20"+
    "\1\36\1\22\13\37\2\10\2\37\4\10\1\11\1\12"+
    "\1\13\1\14\1\10\1\15\1\16\1\17\1\20\1\21"+
    "\1\40\21\10\1\41\1\10\1\11\1\12\1\13\1\14"+
    "\1\10\1\15\1\16\1\17\1\20\1\42\1\22\22\10"+
    "\37\0\3\13\33\0\1\11\2\13\37\0\1\43\6\0"+
    "\1\44\3\45\1\46\1\47\6\45\1\0\2\45\17\0"+
    "\13\23\2\0\2\23\17\0\10\50\1\0\2\50\2\0"+
    "\1\50\20\0\13\25\2\0\2\25\17\0\10\51\1\0"+
    "\2\51\2\0\1\51\4\0\33\52\1\53\2\52\6\0"+
    "\1\54\5\0\13\25\2\0\1\25\1\30\1\0\1\54"+
    "\15\0\13\32\2\0\2\32\17\0\10\55\1\0\2\55"+
    "\2\0\1\55\4\0\33\56\1\57\2\56\6\0\1\60"+
    "\5\0\13\32\2\0\1\32\1\35\1\0\1\60\15\0"+
    "\13\37\2\0\2\37\17\0\13\61\2\0\2\61\3\0"+
    "\1\62\1\0\11\62\1\63\22\62\5\43\1\64\30\43"+
    "\14\0\1\45\1\65\12\45\1\0\2\45\17\0\14\45"+
    "\1\0\2\45\17\0\11\45\1\66\2\45\1\0\2\45"+
    "\17\0\1\45\1\67\12\45\1\0\2\45\17\0\13\50"+
    "\1\0\1\70\2\50\32\0\1\71\6\0\30\52\1\72"+
    "\2\52\1\53\2\52\32\0\1\73\32\0\1\74\6\0"+
    "\30\56\1\75\2\56\1\57\2\56\32\0\1\76\3\0"+
    "\4\43\1\77\1\64\30\43\14\0\2\45\1\100\11\45"+
    "\1\0\2\45\17\0\12\45\1\101\1\45\1\0\2\45"+
    "\17\0\6\45\1\102\5\45\1\0\2\45\33\0\1\71"+
    "\35\0\1\74\21\0\3\45\1\103\10\45\1\0\2\45"+
    "\17\0\2\45\1\104\11\45\1\0\2\45\17\0\4\45"+
    "\1\105\7\45\1\0\2\45\17\0\7\45\1\106\4\45"+
    "\1\0\2\45\3\0\13\107\1\110\14\105\1\107\2\105"+
    "\16\107\1\110\22\107";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1440];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\7\0\1\11\4\1\6\11\6\1\1\11\4\1\1\11"+
    "\1\1\1\11\2\1\1\0\4\1\11\0\1\1\1\0"+
    "\1\1\1\0\3\1\2\11\2\1\1\11\2\1\1\11"+
    "\7\1\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  VASLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1678) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { yybegin(WAITING_VALUE); return VASTypes.KV_SEPARATOR;
          }
        case 24: break;
        case 9: 
          { yybegin(YYINITIAL); return VASTypes.E_VALUES;
          }
        case 25: break;
        case 1: 
          { return TokenType.BAD_CHARACTER;
          }
        case 26: break;
        case 11: 
          { yybegin(YYINITIAL); return VASTypes.VAS_VALUE;
          }
        case 27: break;
        case 12: 
          { yybegin(WAITING_VALUES); return VASTypes.SEPARATOR;
          }
        case 28: break;
        case 7: 
          { yybegin(YYINITIAL); return VASTypes.E_ENTITY;
          }
        case 29: break;
        case 3: 
          { return TokenType.WHITE_SPACE;
          }
        case 30: break;
        case 20: 
          { return VASTypes.COMMENT;
          }
        case 31: break;
        case 16: 
          { yybegin(WAITING_MACRO_IMPL); return VASTypes.MACRO_BRACKET_END;
          }
        case 32: break;
        case 6: 
          { yybegin(YYINITIAL); return VASTypes.B_ENTITY;
          }
        case 33: break;
        case 14: 
          { return VASTypes.MACRO_BRACKET_START;
          }
        case 34: break;
        case 21: 
          { yybegin(YYINITIAL); return VASTypes.MACRO_IMPL_END;
          }
        case 35: break;
        case 23: 
          { return VASTypes.MACRO_IMPORT;
          }
        case 36: break;
        case 22: 
          { yybegin(WAITING_MACRO_NAME); return VASTypes.MACRO_IMPL_START;
          }
        case 37: break;
        case 4: 
          { yybegin(YYINITIAL); return VASTypes.SEPARATOR;
          }
        case 38: break;
        case 19: 
          { return VASTypes.MACRO_CALL_PARAMS;
          }
        case 39: break;
        case 15: 
          { yybegin(WAITING_MACRO_BRACKET_END); return VASTypes.MACRO_NAME;
          }
        case 40: break;
        case 13: 
          { yybegin(WAITING_VALUES); return VASTypes.VAS_VALUE;
          }
        case 41: break;
        case 18: 
          { return VASTypes.MACRO_PARAM;
          }
        case 42: break;
        case 17: 
          { yybegin(END_MACRO); return VASTypes.MACRO_CALL;
          }
        case 43: break;
        case 8: 
          { yybegin(WAITING_VALUES); return VASTypes.B_VALUES;
          }
        case 44: break;
        case 10: 
          { return VASTypes.KEY;
          }
        case 45: break;
        case 2: 
          { return VASTypes.CRLF;
          }
        case 46: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
//            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
