// This is a generated file. Not intended for manual editing.
package intellij.lift.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LiftFundef extends PsiElement {

  @NotNull
  LiftBlock getBlock();

  @NotNull
  LiftIdent getIdent();

  @NotNull
  LiftParams getParams();

  @Nullable
  LiftTyp getTyp();

}
