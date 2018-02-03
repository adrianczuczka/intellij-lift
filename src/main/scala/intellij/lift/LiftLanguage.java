package intellij.lift;

import com.intellij.lang.Language;

public class LiftLanguage extends Language {
    public static final LiftLanguage INSTANCE = new LiftLanguage();
    // private LiftParser parser = new LiftParser();

    private LiftLanguage() {
        super("Lift");
    }
}
