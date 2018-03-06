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
  final val Comments = TokenSet.create(TokenType.WHITE_SPACE)
  final val WhiteSpaces = TokenSet.create(TokenType.WHITE_SPACE)
  final val ReservedKeywords = TokenSet.create(IMPORT_KEYWORD, DEFINITION)
  final val ReservedOperators = TokenSet.create(EQUAL, APPLICATOR, COMPOSER, COLON, COMMA)

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
