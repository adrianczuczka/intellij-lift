package intellij.lift.annotator

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.psi.PsiElement
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import intellij.lift.psi.{LiftTokenType, LiftTypes}

class LiftAnnotator extends Annotator{
  override def annotate(psiElement: PsiElement, annotationHolder: AnnotationHolder): Unit = {
    if (psiElement.getPrevSibling != null
        && psiElement.getPrevSibling.getPrevSibling != null
        && psiElement.getPrevSibling.getPrevSibling.getNode.getElementType == LiftTypes.DEFINITION){
      val annotation = annotationHolder.createInfoAnnotation(psiElement, null)
      annotation.setTextAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
    }
    if (psiElement.getNode.getElementType == LiftTypes.IMPORTABLE){
      if (!psiElement.getText.equals("lift.opencl")) {
        val annotation = annotationHolder.createErrorAnnotation(psiElement, "Invalid import statement. Please use lift.opencl.")
      }
    }
  }
}
