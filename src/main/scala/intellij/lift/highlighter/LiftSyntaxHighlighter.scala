package intellij.lift.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors, HighlighterColors}
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.lift.LiftLexerAdapter
import intellij.lift.psi.LiftTypes
import org.jetbrains.annotations.NotNull

object LiftSyntaxHighlighter{
  final val Separator = createTextAttributesKey("LIFT_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
  final val Key = createTextAttributesKey("LIFT_KEY", DefaultLanguageHighlighterColors.KEYWORD)
  final val Value = createTextAttributesKey("LIFT_VALUE", DefaultLanguageHighlighterColors.STRING)
  final val Comment = createTextAttributesKey("LIFT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  final val BadCharacter = createTextAttributesKey("LIFT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
}

class LiftSyntaxHighlighter extends SyntaxHighlighterBase{
  // TODO: Implement unimplemented methods from the interface
  import com.intellij.openapi.fileTypes.SyntaxHighlighterBase._

  @NotNull
  override def getHighlightingLexer: Lexer = {
    new LiftLexerAdapter
  }

  @NotNull
  override def getTokenHighlights(iElementType: IElementType): Array[TextAttributesKey] = {
    import intellij.lift.highlighter.LiftSyntaxHighlighter._

    iElementType match {
      case TokenType.BAD_CHARACTER => pack(BadCharacter)
      case LiftTypes.SEPARATOR => pack(Separator)
      case LiftTypes.KEY => pack(Key)
      case LiftTypes.VALUE => pack(Value)
      case LiftTypes.COMMENT => pack(Comment)
      case _ => pack(null)
    }
  }

}
