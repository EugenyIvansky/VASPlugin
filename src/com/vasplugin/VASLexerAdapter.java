package com.vasplugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class VASLexerAdapter extends FlexAdapter {
    public VASLexerAdapter() {
        super(new VASLexer((Reader) null));
    }
}