package intellij.lift.editor

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import intellij.lift.psi.{LiftTokenType, LiftTypes}

class LiftCommenter extends CodeDocumentationAwareCommenter{
  override def getLineCommentPrefix: String = {
    "//"
  }

  override def getBlockCommentPrefix: String = {
    "/*"
  }

  override def getBlockCommentSuffix: String = {
    "*/"
  }

  override def getCommentedBlockCommentPrefix: String = {
    "/*"
  }

  override def getCommentedBlockCommentSuffix: String = {
    "*/"
  }

  // TODO: Add the LiftType associated with line / block comments
  override def getLineCommentTokenType: IElementType = {
    LiftTypes.COMMENT
  }

  override def getBlockCommentTokenType: IElementType = {
    LiftTypes.COMMENT
  }

  // Lift documentation does not have similar structure as Javadoc so makes no sense to put some values here.

  override def getDocumentationCommentTokenType: IElementType = {
    null
  }

  override def getDocumentationCommentLinePrefix: String = {
    null
  }

  override def getDocumentationCommentSuffix: String = {
    null
  }

  override def getDocumentationCommentPrefix: String = {
    null
  }

  override def isDocumentationComment(psiComment: PsiComment): Boolean = {
    psiComment.getText.startsWith("//") || psiComment.getText.startsWith("/*")
  }
}
