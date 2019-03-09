package intellij.lift.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors, HighlighterColors}
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import intellij.lift.LiftLexerAdapter
import intellij.lift.LiftParserDefinition._
import intellij.lift.psi.LiftTypes
import org.jetbrains.annotations.NotNull

object LiftSyntaxHighlighter {
  final val Importable = createTextAttributesKey("LIFT_IMPORTABLE", DefaultLanguageHighlighterColors.STRING)
  final val Comment = createTextAttributesKey("LIFT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  final val BadCharacter = createTextAttributesKey("LIFT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
  final val Identifier = createTextAttributesKey("LIFT_IDENTIFIER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
  final val Numeric = createTextAttributesKey("LIFT_NUMERIC_VALUE", DefaultLanguageHighlighterColors.NUMBER)

  // keywords
  final val Keyword = createTextAttributesKey("LIFT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
  final val Operator = createTextAttributesKey("LIFT_OPERATION", DefaultLanguageHighlighterColors.OPERATION_SIGN)
  final val FunctionDeclaration = createTextAttributesKey("LIFT_FUN_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
  final val VariableDeclaration = createTextAttributesKey("LIFT_VAR_NAME", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE)
  final val Types = createTextAttributesKey("LIFT_TYPES", DefaultLanguageHighlighterColors.FUNCTION_CALL)

  // punctuation
  final val Parens = createTextAttributesKey("LIFT_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
  final val Braces = createTextAttributesKey("LIFT_BRACES", DefaultLanguageHighlighterColors.BRACES)
  final val Brackets = createTextAttributesKey("LIFT_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
}

class LiftSyntaxHighlighter extends SyntaxHighlighterBase {

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
      case LiftTypes.COMMENT | LiftTypes.LINE_COMMENT | LiftTypes.BLOCK_COMMENT | LiftTypes.NOT_TERMINATED_COMMENT
      => pack(Comment)
      case LiftTypes.IMPORTABLE => pack(Importable)
      case LiftTypes.VARDEF => pack(VariableDeclaration)
      case LiftTypes.LEFT_PAREN | LiftTypes.RIGHT_PAREN => pack(Parens)
      case LiftTypes.LEFT_BRACE | LiftTypes.RIGHT_BRACE => pack(Braces)
      case LiftTypes.LEFT_BRACKET | LiftTypes.RIGHT_BRACKET => pack(Brackets)
      case LiftTypes.IDENTIFIER => pack(Identifier)
      case et if ReservedKeywords.contains(et) => pack(Keyword)
      case et if ReservedOperators.contains(et) => pack(Operator)
      case et if ComposedTypes.contains(et) => pack(Types)
      case LiftTypes.NUMERIC_VALUE | LiftTypes.BOOLEAN => pack(Numeric)
      case LiftTypes.TYPE | LiftTypes.ARRAY_TYPE | LiftTypes.TUPLE_TYPE => pack(Types)
      case _ => pack(null)
    }
  }

}
