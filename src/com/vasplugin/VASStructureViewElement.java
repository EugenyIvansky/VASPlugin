package com.vasplugin;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.vasplugin.psi.VASEntity;
import com.vasplugin.psi.VASFile;

import java.util.ArrayList;
import java.util.List;

public class VASStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private PsiElement element;

    public VASStructureViewElement(PsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return element instanceof NavigationItem &&
                ((NavigationItem)element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element instanceof NavigationItem &&
                ((NavigationItem)element).canNavigateToSource();
    }

    @Override
    public String getAlphaSortKey() {
        return element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null;
    }

    @Override
    public ItemPresentation getPresentation() {
        return element instanceof NavigationItem ?
                ((NavigationItem) element).getPresentation() : null;
    }

    @Override
    public TreeElement[] getChildren() {
        if (element instanceof VASFile) {
            List<VASEntity> entities = new ArrayList<VASEntity>();
            VASUtil.getAllEntities(entities, element);
            List<TreeElement> treeElements = new ArrayList<TreeElement>(entities.size());
            for (VASEntity entity : entities) {
                treeElements.add(new VASStructureViewElement(entity));
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        } else {
            return EMPTY_ARRAY;
        }
    }
}
