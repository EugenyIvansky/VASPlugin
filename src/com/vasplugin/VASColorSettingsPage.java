package com.vasplugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class VASColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Key", VASSyntaxHighlighter.KEY),
            new AttributesDescriptor("Service symbol", VASSyntaxHighlighter.SERVICE_SYMBOL),
            new AttributesDescriptor("Value", VASSyntaxHighlighter.VALUE),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return VASIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new VASSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return  "{\n" +
                "\"result\" : (\"res1\", \"res2\"),\n" +
                "\"data\" : \"sdsd\",\n" +
                "\"data2\" : 123,\n" +
                "\"data3\" : 222.324\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "VAS";
    }
}