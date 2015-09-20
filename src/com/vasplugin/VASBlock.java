package com.vasplugin;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.vasplugin.psi.VASTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VASBlock extends AbstractBlock {
    private SpacingBuilder spacingBuilder;

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
            if (child.getElementType() != TokenType.WHITE_SPACE &&
                    (previousChild == null || previousChild.getElementType() != VASTypes.CRLF ||
                            child.getElementType() != VASTypes.CRLF)) {

                if(child.getElementType() == VASTypes.KEY_VALUE_PAIR_LIST){
                    buildChildren(blocks, child);
                } else {
                    Block block = new VASBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                            spacingBuilder);
                    blocks.add(block);
                }
            }

            previousChild = child;
            child = child.getTreeNext();
        }
    }

    @Override
    public Indent getIndent() {
        if(myNode.getTreeParent().getElementType() == VASTypes.ENTITY || myNode.getTreeParent().getElementType() == VASTypes.KEY_VALUE_PAIR_LIST || myNode.getTreeParent().getElementType() == VASTypes.VALUES){
            if (myNode.getElementType() == VASTypes.KEY_VALUE_PAIR || myNode.getElementType() == VASTypes.COMMENT || myNode.getElementType() == VASTypes.ENTITY) {
                return Indent.getNormalIndent();
            }
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
