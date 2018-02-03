package intellij.lift.psi;

import com.intellij.psi.tree.IElementType;
import intellij.lift.LiftLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LiftElementType extends IElementType {
    public LiftElementType(@NotNull @NonNls String debugName) {
        super(debugName, LiftLanguage.INSTANCE);
    }
}
