package intellij.lift.highlihgter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import intellij.lift.lexer.LiftLexer
import org.jetbrains.annotations.NotNull

object LiftSyntaxHighlighter{

}

class LiftSyntaxHighlighter extends SyntaxHighlighterBase{
  // TODO: Implement unimplemented methods from the interface

  @NotNull
  override def getHighlightingLexer: Lexer = ???

  @NotNull
  override def getTokenHighlights(iElementType: IElementType): Array[TextAttributesKey] = ???

}
