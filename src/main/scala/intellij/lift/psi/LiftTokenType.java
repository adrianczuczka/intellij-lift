package intellij.lift.psi;

import com.intellij.psi.tree.IElementType;
import intellij.lift.LiftLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LiftTokenType extends IElementType {
    public LiftTokenType(@NotNull @NonNls String debugName) {
        super(debugName, LiftLanguage.Instance);
    }

    @Override
    public String toString(){
        return "LiftTokenType." + super.toString();
    }
}
