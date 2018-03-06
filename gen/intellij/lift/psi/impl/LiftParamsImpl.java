// This is a generated file. Not intended for manual editing.
package intellij.lift.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static intellij.lift.psi.LiftTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import intellij.lift.psi.*;

public class LiftParamsImpl extends ASTWrapperPsiElement implements LiftParams {

  public LiftParamsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LiftVisitor visitor) {
    visitor.visitParams(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LiftVisitor) accept((LiftVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LiftIdent> getIdentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LiftIdent.class);
  }

  @Override
  @NotNull
  public List<LiftTyp> getTypList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LiftTyp.class);
  }

}
