package net.masterthought.dlanguage.codeinsight;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.ElementDescriptionUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.usageView.UsageViewLongNameLocation;
import com.intellij.usageView.UsageViewNodeTextLocation;
import com.intellij.usageView.UsageViewTypeLocation;
import net.masterthought.dlanguage.lexer.DLexer;
import net.masterthought.dlanguage.psi.DTokenSets;
import net.masterthought.dlanguage.psi.interfaces.DElementTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DFindUsagesProvider implements FindUsagesProvider {
    @SuppressWarnings("UnusedDeclaration")
    private final static Logger LOG = Logger.getInstance(DFindUsagesProvider.class);
    // Second parameter is nodes that are PsiNamedElements in practice.
    private final static WordsScanner SCANNER =
            new DefaultWordsScanner(new DLexer(),
                    TokenSet.create(DElementTypes.IDENTIFIER),
                    DTokenSets.COMMENTS, DTokenSets.STRING_LITERALS);
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return SCANNER;
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
//        return psiElement instanceof PsiNamedElement;
        return true;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        // TODO: Use HelpID after 13.1.
        return "reference.dialogs.findUsages.other";
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewTypeLocation.INSTANCE);
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewLongNameLocation.INSTANCE);
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewNodeTextLocation.INSTANCE);
    }
}

