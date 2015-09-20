package com.vasplugin;

import com.intellij.lang.Language;

public class VASLanguage extends Language {
    public static final VASLanguage INSTANCE = new VASLanguage();

    private VASLanguage() {
        super("VAS");
    }
}

