package intellij.lift.completion

import com.intellij.codeInsight.completion._
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import intellij.lift.LiftLanguage
import intellij.lift.psi.LiftTypes
import intellij.lift.psi.impl.LiftImportImpl

import scala.collection.JavaConverters._

class LiftCompletionContributor extends CompletionContributor{
  private final val CoreLift = Stream("map", "zip", "reduce", "split", "join", "iterate", "reorder", "transpose")
  private final val OpenCLLift = Stream("mapGlb", "mapLcl", "mapWrg", "mapSeq", "partRed", "reduceSeq",
                                        "toGlobal", "toLocal", "toPrivate", "asVector", "asScalar", "vectorize")
  // add future sets of methods for

  val provider = new CompletionProvider[CompletionParameters] {
    override def addCompletions(v: CompletionParameters, processingContext: ProcessingContext,
                                completionResultSet: CompletionResultSet): Unit = {
      if (!v.getOriginalPosition.getParent.toString.equals("Lift file") ||
        v.getOriginalPosition.getPrevSibling.getPrevSibling.toString.equals("PsiElement(LiftTokenType.COMPOSER)")) {
        completionResultSet.addAllElements(
          CoreLift.map(cl => LookupElementBuilder.create(cl)).asJavaCollection)

        val imports = getImportStatements(v.getOriginalFile.getChildren)
        if (imports.length > 0){
            if (imports.toList.contains("lift.opencl")) {
              completionResultSet.addAllElements(
                OpenCLLift.map(cl => LookupElementBuilder.create(cl)).asJavaCollection)
            }
          }
      }
    }
  }

  extend(CompletionType.BASIC,
    PlatformPatterns.psiElement(LiftTypes.IDENTIFIER).withLanguage(LiftLanguage.Instance), provider)

  def getImportStatements(a: Array[PsiElement]): Array[String] = {
    val result = a flatMap {
      case e: LiftImportImpl => Some(e.getNode.getPsi.findElementAt(7).getText)
      case _ => None
    }
    result
  }
}
