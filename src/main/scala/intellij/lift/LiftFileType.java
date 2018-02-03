package intellij.lift;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LiftFileType extends LanguageFileType {
    public static final LanguageFileType INSTANCE = new LiftFileType();

    private LiftFileType() {
        super(LiftLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Lift file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Lift language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "lift";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return LiftIcons.FILE;
    }
}
