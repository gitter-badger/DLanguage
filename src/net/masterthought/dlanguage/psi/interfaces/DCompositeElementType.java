package net.masterthought.dlanguage.psi.interfaces;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;


/**
 * A composite element is IntelliJ-speak for non-leaf node.
 *
 * This class is a container for all unexpected things we send off to the
 * factory in DElementypes2.
 */
public class DCompositeElementType extends ASTWrapperPsiElement {
    public DCompositeElementType(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
//        if (visitor instanceof HaskellVisitor) ((HaskellVisitor)visitor).visitVarid(this);
        // else
        super.accept(visitor);
    }
}

