package com.vasplugin;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.vasplugin.psi.VASTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.intellij.psi.TokenType.*;
import static com.vasplugin.psi.VASTypes.*;

public class VASBlock extends AbstractBlock {
    private SpacingBuilder spacingBuilder;

    private Set<IElementType> typesForParentBlockForNormalIndent = new HashSet<IElementType>(Arrays.asList(ENTITY, KEY_VALUE_PAIR_LIST, VALUES));
    private Set<IElementType> typesForChildrenBlocksForNormalIndent = new HashSet<IElementType>(Arrays.asList(KEY_VALUE_PAIR, COMMENT, ENTITY));


    protected VASBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment,
                       SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<Block>();
        buildChildren(blocks, myNode);
        return blocks;
    }

    protected void buildChildren(List<Block> blocks, ASTNode node) {
        ASTNode child = node.getFirstChildNode();
        ASTNode previousChild = null;
        while (child != null) {
            if (child.getElementType() != WHITE_SPACE && notSequenceOfCRLF(child, previousChild)) {
                if (child.getElementType() == KEY_VALUE_PAIR_LIST) {
                    buildChildren(blocks, child);
                } else {
                    blocks.add(new VASBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), spacingBuilder));
                }
            }

            previousChild = child;
            child = child.getTreeNext();
        }
    }

    private boolean notSequenceOfCRLF(ASTNode child, ASTNode previousChild) {
        return previousChild == null || previousChild.getElementType() != CRLF || child.getElementType() != CRLF;
    }

    @Override
    public Indent getIndent() {
        if (myNode.getTreeParent() == null || !typesForParentBlockForNormalIndent.contains(myNode.getTreeParent().getElementType())) {
            return Indent.getNoneIndent();
        }

        if (typesForChildrenBlocksForNormalIndent.contains(myNode.getElementType())) {
            return Indent.getNormalIndent();
        }

        return Indent.getNoneIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }
}
