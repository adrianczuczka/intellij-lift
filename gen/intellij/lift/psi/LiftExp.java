// This is a generated file. Not intended for manual editing.
package intellij.lift.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LiftExp extends PsiElement {

  @Nullable
  LiftComposedFuncall getComposedFuncall();

  @Nullable
  LiftExp getExp();

  @Nullable
  LiftFuncall getFuncall();

  @Nullable
  LiftSymbol getSymbol();

  @Nullable
  LiftValue getValue();

  @Nullable
  LiftVardef getVardef();

}
