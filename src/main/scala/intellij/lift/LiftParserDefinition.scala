package intellij.lift

import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.{IFileElementType, TokenSet}
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile, TokenType}
import intellij.lift.parser.LiftParser
import intellij.lift.psi.LiftTypes
import intellij.lift.psi.LiftTypes._

object LiftParserDefinition {
  final val LiftParser = new LiftParser
  final val File = new IFileElementType(LiftLanguage.Instance)
  final val Comments = TokenSet.create(LINE_COMMENT, BLOCK_COMMENT, NOT_TERMINATED_COMMENT)
  final val WhiteSpaces = TokenSet.create(TokenType.WHITE_SPACE)
  final val ReservedKeywords = TokenSet.create(IMPORT_KEYWORD, FUNDEFINITION, VARDEFINITION)
  final val ReservedOperators = TokenSet.create(APPLICATOR, COMPOSER)
  final val ComposedTypes = TokenSet.create(ARRAY, TUPLE)
  final val Literals = TokenSet.create(NUMERIC_VALUE, BOOLEAN)

}

class LiftParserDefinition extends ParserDefinition{

  override def createLexer(project: Project): Lexer = {
    new LiftLexerAdapter
  }

  override def createParser(project: Project): PsiParser = {
    LiftParserDefinition.LiftParser
  }

  override def getFileNodeType: IFileElementType = {
    LiftParserDefinition.File
  }

  override def createElement(astNode: ASTNode): PsiElement = {
    LiftTypes.Factory.createElement(astNode)
  }

  override def createFile(fileViewProvider: FileViewProvider): PsiFile = {
    new LiftFile(fileViewProvider)
  }

  override def getStringLiteralElements: TokenSet = {
    TokenSet.EMPTY
  }

  override def spaceExistanceTypeBetweenTokens(astNode: ASTNode, astNode1: ASTNode): ParserDefinition.SpaceRequirements = {
    SpaceRequirements.MAY
  }

  override def getCommentTokens: TokenSet = {
    LiftParserDefinition.Comments
  }

  override def getWhitespaceTokens: TokenSet = {
    LiftParserDefinition.WhiteSpaces
  }
}
