package intellij.lift;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class LiftLexerAdapter extends FlexAdapter{
    public LiftLexerAdapter() {
        super(new LiftLexer((Reader) null));
    }
}
