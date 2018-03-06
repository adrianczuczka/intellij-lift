// This is a generated file. Not intended for manual editing.
package intellij.lift.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LiftBlock extends PsiElement {

  @Nullable
  LiftArguments getArguments();

  @NotNull
  List<LiftStmt> getStmtList();

}
