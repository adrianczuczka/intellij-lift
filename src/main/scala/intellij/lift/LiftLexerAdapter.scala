package intellij.lift

import com.intellij.lexer.FlexAdapter
import intellij.lift.lexer.LiftLexer

class LiftLexerAdapter extends FlexAdapter(new LiftLexer)
