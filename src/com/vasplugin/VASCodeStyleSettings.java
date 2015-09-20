package com.vasplugin;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class VASCodeStyleSettings extends CustomCodeStyleSettings {
    public VASCodeStyleSettings(CodeStyleSettings settings) {
        super("VASCodeStyleSettings", settings);
    }
}
