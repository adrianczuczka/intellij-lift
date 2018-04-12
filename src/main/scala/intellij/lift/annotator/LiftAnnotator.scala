package intellij.lift.annotator

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.psi.PsiElement
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors, HighlighterColors}
import intellij.lift.psi.impl.LiftImportImpl
import intellij.lift.psi.{LiftTokenType, LiftTypes}

import scala.runtime.ScalaRunTime._

class LiftAnnotator extends Annotator{
  private final val OpenCLLift = Stream("mapGlb", "mapLcl", "mapWrg", "mapSeq", "partRed", "reduceSeq",
    "toGlobal", "toLocal", "toPrivate", "asVector", "asScalar", "vectorize")

  override def annotate(psiElement: PsiElement, annotationHolder: AnnotationHolder): Unit = {

    // FunDecl name
    if (psiElement.getPrevSibling != null
        && psiElement.getPrevSibling.getPrevSibling != null
        && psiElement.getPrevSibling.getPrevSibling.getNode.getElementType == LiftTypes.DEFINITION){
      val annotation = annotationHolder.createInfoAnnotation(psiElement, null)
      annotation.setTextAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
    }

    // IMPORT
    if (psiElement.getNode.getElementType == LiftTypes.IMPORTABLE){
      if (!psiElement.getText.equals("lift.opencl")) {
        val annotation = annotationHolder.createErrorAnnotation(psiElement,
                                                                "Invalid import statement. Please use lift.opencl.")
      }
    }

    // recognition for non-default methods based on import
    val imports = getImportStatements(psiElement.getContainingFile.getChildren)

    if (psiElement.getNode.getElementType == LiftTypes.IDENTIFIER) {
      if (!imports.contains("lift.opencl") && OpenCLLift.contains(psiElement.getText)){

        val annotation = annotationHolder.createErrorAnnotation(psiElement,
                                                                "Unresolved reference to " + psiElement.getText + ". " +
                                                                "Import OpenCL package.")
        annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
      }
    }

    if (psiElement.getNode.getElementType == LiftTypes.IDENTIFIER) {
      if (imports.contains("lift.opencl") && OpenCLLift.contains(psiElement.getText)) {

        val annotation = annotationHolder.createInfoAnnotation(psiElement, null)
        annotation.setTextAttributes(DefaultLanguageHighlighterColors.FUNCTION_CALL)
      }
    }
  }

  def getImportStatements(a: Array[PsiElement]): Array[String] = {
    val result = a flatMap {
      case e: LiftImportImpl => Some(e.findElementAt(7).getText)
      case _ => None
    }
    result
  }
}
