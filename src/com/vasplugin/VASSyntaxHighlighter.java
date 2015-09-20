package com.vasplugin;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.vasplugin.psi.VASTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class VASSyntaxHighlighter extends SyntaxHighlighterBase {

    private List<IElementType> serviceSymbols = Arrays.asList(VASTypes.B_ENTITY, VASTypes.E_ENTITY,
            VASTypes.B_VALUES, VASTypes.E_ENTITY,
            VASTypes.KV_SEPARATOR, VASTypes.SEPARATOR);

    public static final TextAttributesKey SERVICE_SYMBOL = createTextAttributesKey("VAS_SERVICE_SYMBOL", TextAttributesKey.createTextAttributesKey("JAVA_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN));
    public static final TextAttributesKey KEY = createTextAttributesKey("VAS_KEY", TextAttributesKey.createTextAttributesKey("JAVA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD));
    public static final TextAttributesKey VALUE = createTextAttributesKey("VAS_VALUE", TextAttributesKey.createTextAttributesKey("JAVA_STRING", DefaultLanguageHighlighterColors.STRING));
    public static final TextAttributesKey COMMENT = createTextAttributesKey("VAS_COMMENT", TextAttributesKey.createTextAttributesKey("JAVA_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT));
    public static final TextAttributesKey MACRO = createTextAttributesKey("VAS_MACRO",new TextAttributes(Color.MAGENTA, null, null, null, Font.BOLD));
    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", new TextAttributes(Color.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SERVICE_SYMBOL_KEYS = new TextAttributesKey[]{SERVICE_SYMBOL};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] MACRO_KEYS = new TextAttributesKey[]{MACRO};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new VASLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (serviceSymbols.contains(tokenType)) {
            return SERVICE_SYMBOL_KEYS;
        } else if (tokenType.equals(VASTypes.KEY)) {
            return KEY_KEYS;
        } else if (tokenType.equals(VASTypes.VAS_VALUE)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(VASTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (tokenType.equals(VASTypes.MACRO_CALL)) {
            return MACRO_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
