package intellij.lift

import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.{IFileElementType, TokenSet}
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile, TokenType}
import intellij.lift.parser.LiftParser

object LiftParserDefinition{
  final val LiftParser = new LiftParser
  final val WhiteSpaces = TokenSet.create(TokenType.WHITE_SPACE)
}

class LiftParserDefinition extends ParserDefinition{
  @NotNull
  def createLexer(project: Project): Lexer = {
    new LiftLexerAdapter
  }

  def createParser(project: Project): PsiParser = {
    LiftParserDefinition.LiftParser
  }

  def getFileNodeType: IFileElementType = {
    new IFileElementType(LiftLanguage.Instance)
  }

  @NotNull
  override def getWhitespaceTokens: TokenSet = {
    LiftParserDefinition.WhiteSpaces
  }

  @NotNull
  def getCommentTokens: TokenSet = {
    TokenSet.EMPTY
  }

  @NotNull
  def getStringLiteralElements: TokenSet = {
    TokenSet.EMPTY
  }

  @NotNull
  def createElement(node: ASTNode): PsiElement = {
    Factory.createElement(node)
  }

  @NotNull
  def createFile(viewProvider: FileViewProvider): PsiFile = {
    new LiftFile(viewProvider)
  }

  def spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements = {
    SpaceRequirements.MAY
  }
}
