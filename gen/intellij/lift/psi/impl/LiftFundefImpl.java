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

public class LiftFundefImpl extends ASTWrapperPsiElement implements LiftFundef {

  public LiftFundefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LiftVisitor visitor) {
    visitor.visitFundef(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LiftVisitor) accept((LiftVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LiftBlock getBlock() {
    return findNotNullChildByClass(LiftBlock.class);
  }

  @Override
  @NotNull
  public LiftIdent getIdent() {
    return findNotNullChildByClass(LiftIdent.class);
  }

  @Override
  @NotNull
  public LiftParams getParams() {
    return findNotNullChildByClass(LiftParams.class);
  }

  @Override
  @Nullable
  public LiftTyp getTyp() {
    return findChildByClass(LiftTyp.class);
  }

}
