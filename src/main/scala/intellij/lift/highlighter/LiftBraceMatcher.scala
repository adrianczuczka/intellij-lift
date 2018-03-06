package intellij.lift.highlighter

import com.intellij.lang.{BracePair, PairedBraceMatcher}
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import intellij.lift.LiftParserDefinition._

object LiftBraceMatcher{
  import intellij.lift.psi.LiftTypes._

  private final val PAIRS = Array(
    new BracePair(LEFT_BRACE, RIGHT_BRACE, false),
    new BracePair(LEFT_BRACKET, RIGHT_BRACKET, true),
    new BracePair(LEFT_PAREN, RIGHT_PAREN, true)
  )
}

class LiftBraceMatcher extends PairedBraceMatcher{
  override def isPairedBracesAllowedBeforeType(lBraceType: IElementType, elementType: IElementType): Boolean = {
    !Literals.contains(elementType)
  }

  override def getPairs: Array[BracePair] = LiftBraceMatcher.PAIRS

  override def getCodeConstructStart(psiFile: PsiFile, openingBraceOffset: Int): Int = {
    openingBraceOffset
  }
}
