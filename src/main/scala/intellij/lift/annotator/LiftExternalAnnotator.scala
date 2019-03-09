package intellij.lift.annotator

import com.intellij.lang.annotation.{AnnotationHolder, ExternalAnnotator}
import com.intellij.openapi.editor.Editor
import com.intellij.psi.{PsiDocumentManager, PsiElement, PsiFile}
import ir.{LiftTypeErrorExceptionWithPosition, VariableNotDeclaredExceptionWithPosition}
import lang.parser.{LiftNode, LiftParserInit}

import scala.collection.mutable
import scala.util.parsing.input.{NoPosition, Position}

case class ExceptionDetails(element: Option[PsiElement], msg: String)

class LiftExternalAnnotator extends ExternalAnnotator[PsiFile, Either[List[LiftNode], List[ExceptionDetails]]] {
  override def collectInformation(file: PsiFile, editor: Editor, hasErrors: Boolean): PsiFile = {
    file
  }

  override def doAnnotate(file: PsiFile): Either[List[LiftNode], List[ExceptionDetails]] = {
    val fileContents = file.getText/*
    var avg = 0L
    for(x <- 1 until 51){
      var beforeTime = System.currentTimeMillis()
      var test = new LiftParserInit()(fileContents)
      var diff = System.currentTimeMillis() - beforeTime
      print(diff + " ")
      avg += diff
      Thread.sleep(100)
    }
    println()
    println(avg.toDouble / 50.toDouble)*/
    val result = new LiftParserInit()(fileContents)
    result match {
      case Left(nodeList) => Left(nodeList)
      case Right(list) =>
        //println("error at " + pos)
        //val element = getElementAtLine(file, pos.line - 1, pos.column)
        //Right(ExceptionDetails(element, msg))
        Right(list.map {
          case e: LiftTypeErrorExceptionWithPosition =>
            val element = getElementAtLine(file, e.position)
            ExceptionDetails(element, e.message)
        }.toList)
    }
  }

  def getElementAtLine(file: PsiFile, position: Position): Option[PsiElement] = position match {
    case NoPosition => None
    case _ =>
      val line = position.line - 1
      val column = position.column
      val document = PsiDocumentManager.getInstance(file.getProject).getDocument(file)
      val offset = document.getLineStartOffset(line)
      var element = file.getViewProvider.findElementAt(offset + column)
      if (document.getLineNumber(element.getTextOffset) != line) element = element.getNextSibling
      Option(element)
  }

  override def apply(file: PsiFile, annotationResult: Either[List[LiftNode], List[ExceptionDetails]], holder: AnnotationHolder): Unit = {
    //println("apply")
    annotationResult match {
      case Left(nodeList) => //println(node)
      case Right(e) =>
        e.foreach { exception =>
          exception.element match {
            case Some(x) => holder.createErrorAnnotation(x, exception.msg)
            case None => println("element is null")
          }
        }
    }
  }
}