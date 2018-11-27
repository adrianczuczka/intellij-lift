package intellij.lift.annotator

import com.intellij.lang.annotation.{AnnotationHolder, ExternalAnnotator}
import com.intellij.openapi.editor.Editor
import com.intellij.psi.{PsiDocumentManager, PsiElement, PsiFile}
import ir.TypeMismatchExceptionWithPosition
import lang.parser.{LiftNode, LiftParserInit}

import scala.io.Source

case class ExceptionDetails(element: Option[PsiElement], msg: String)

class LiftExternalAnnotator extends ExternalAnnotator[PsiFile, Either[LiftNode, ExceptionDetails]] {
  override def collectInformation(file: PsiFile, editor: Editor, hasErrors: Boolean):  PsiFile = {
    //super.collectInformation(file, editor, hasErrors)
    //println("collectInformation")
    file
  }

  override def doAnnotate(file: PsiFile): Either[LiftNode, ExceptionDetails] = {
    val fileContents = file.getText
    val result = LiftParserInit(fileContents)
    result match {
      case Left(node) => Left(node)
      case Right(TypeMismatchExceptionWithPosition(msg, pos)) =>
        //println("error at " + pos)
        val element = getElementAtLine(file, pos.line - 1, pos.column)
        Right(ExceptionDetails(element, msg))
      case Right(e) =>
        e.printStackTrace()
        null
    }
  }

  def getElementAtLine(file: PsiFile, line: Int, column: Int): Option[PsiElement] = {
    val document = PsiDocumentManager.getInstance(file.getProject).getDocument(file)
    val offset = document.getLineStartOffset(line)
    var element = file.getViewProvider.findElementAt(offset + column)
    if (document.getLineNumber(element.getTextOffset) != line) element = element.getNextSibling
    Option(element)
  }

  override def apply(file: PsiFile, annotationResult: Either[LiftNode, ExceptionDetails], holder: AnnotationHolder): Unit = {
    //println("apply")
    annotationResult match {
      case Left(node) => println(node)
      case Right(e) =>
        e.element match {
          case Some(x) => holder.createErrorAnnotation(x, e.msg)
          case None => println("element is null")
        }
    }
  }
}


/*
(\p6 ->
  int_add(2, 2)
)
*/