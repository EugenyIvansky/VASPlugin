package com.vasplugin;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;

import com.vasplugin.psi.VASEntity;
import com.vasplugin.psi.VASMacroImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VASChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<VASMacroImpl> macros = VASUtil.findMacros(project);
        List<String> names = new ArrayList<String>(macros.size());
        for (VASMacroImpl macro : macros) {
            if (macro.getName() != null && macro.getName().length() > 0) {
                names.add(macro.getName());
            }
        }
        List<VASEntity> entities = VASUtil.findEntity(project);
        for (VASEntity entity : entities) {
            if (entity.getName() != null && entity.getName().length() > 0) {
                names.add(entity.getName());
            }
        }

        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        List<VASMacroImpl> macros = VASUtil.findMacros(project, name);
        List<VASEntity> entities = VASUtil.findEntity(project, name);
        ArrayList<NavigationItem> items = new ArrayList<>(macros.size() + entities.size());

        items.addAll(Arrays.asList(macros.toArray(new NavigationItem[macros.size()])));
        items.addAll(Arrays.asList(entities.toArray(new NavigationItem[entities.size()])));

        return items.toArray(new NavigationItem[items.size()]);
    }
}
