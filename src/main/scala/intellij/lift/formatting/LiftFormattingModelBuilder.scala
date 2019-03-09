package intellij.lift.formatting

import com.intellij.formatting._
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings
import intellij.lift.LiftLanguage
import intellij.lift.psi.LiftTypes

object LiftFormattingModelBuilder {
  private def createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder = {
    new SpacingBuilder(settings, LiftLanguage.Instance)
      .after(LiftTypes.EQUAL)
      .spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
      .before(LiftTypes.RIGHT_PAREN)
      .none()
  }
}

class LiftFormattingModelBuilder extends FormattingModelBuilder {
  override def createModel(element: PsiElement, settings: CodeStyleSettings): FormattingModel = {
    FormattingModelProvider
      .createFormattingModelForPsiFile(element.getContainingFile,
        new LiftBlock(element.getNode,
          Wrap.createWrap(WrapType.NONE, false),
          Alignment.createAlignment(),
          LiftFormattingModelBuilder.createSpaceBuilder(settings)),
        settings
      )
  }
}
