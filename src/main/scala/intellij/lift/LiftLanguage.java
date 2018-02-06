package intellij.lift;

import com.intellij.lang.Language;

public class LiftLanguage extends Language {
    public static final LiftLanguage Instance = new LiftLanguage();

    private LiftLanguage() {
        super("Lift");
    }
}
