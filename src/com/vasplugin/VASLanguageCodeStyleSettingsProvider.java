package com.vasplugin;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;

public class VASLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
    @NotNull
    @Override
    public Language getLanguage() {
        return VASLanguage.INSTANCE;
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {

            consumer.showStandardOptions("SPACE_AFTER_COMMA");
            consumer.renameStandardOption("SPACE_AFTER_COMMA", "After (,)");

            consumer.showStandardOptions("SPACE_BEFORE_COMMA");
            consumer.renameStandardOption("SPACE_BEFORE_COMMA", "Before (,)");

            consumer.showStandardOptions("SPACE_AFTER_SEMICOLON");
            consumer.renameStandardOption("SPACE_AFTER_SEMICOLON", "After (:)");

            consumer.showStandardOptions("SPACE_BEFORE_SEMICOLON");
            consumer.renameStandardOption("SPACE_BEFORE_SEMICOLON", "Before (:)");

        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {

//            consumer.showStandardOptions("BLANK_LINES_AROUND_CLASS");
//            consumer.renameStandardOption("BLANK_LINES_AROUND_CLASS", "add lines before ({)");

            consumer.showAllStandardOptions();
        } else if (settingsType == SettingsType.WRAPPING_AND_BRACES_SETTINGS) {
            consumer.showAllStandardOptions();
//            consumer.showStandardOptions("SPACE_AFTER_COLON");
//            consumer.renameStandardOption("SPACE_AFTER_COLON", "new line before ({)");

        }
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {
        return "{\n" +
                "\"result\" : (\"res1\", \"res2\"),\n" +
                "\"data\" : \"sdsd\",\n" +
                "\"data2\" : 123,\n" +
                "\"data3\" : 222.324 \n" +
                "}";
    }
}
