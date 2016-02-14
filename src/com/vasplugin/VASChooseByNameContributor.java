package com.vasplugin;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;

import com.vasplugin.psi.VASEntity;
import com.vasplugin.psi.VASMacroImpl;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class VASChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<VASMacroImpl> macros = VASUtil.findMacros(project);
        List<VASEntity> entities = VASUtil.findEntity(project);

        List<String> names = macros.stream()
                .filter(macro -> !StringUtils.isEmpty(macro.getName()))
                .map(VASMacroImpl::getName)
                .collect(toList());

        names.addAll(entities.stream()
                .filter(entity -> !StringUtils.isEmpty(entity.getName()))
                .map(VASEntity::getName)
                .collect(toList()));

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
