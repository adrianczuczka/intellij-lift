package intellij.lift.highlighter

import java.util
import javax.swing.Icon

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import intellij.lift.LiftIcons
import intellij.lift.highlighter.LiftSyntaxHighlighter._
import scala.collection.JavaConverters._

object LiftColourSettingsPage{
  private final val Descriptors = Array[AttributesDescriptor](
    new AttributesDescriptor("Illegal character", BadCharacter),
    new AttributesDescriptor("Keyword", Keyword),
    new AttributesDescriptor("Parentheses", Parens),
    new AttributesDescriptor("Brace", Braces),
    new AttributesDescriptor("Bracket", Brackets),
    new AttributesDescriptor("Variable", Identifier),
    new AttributesDescriptor("Operator", Operator),
  )
  private final val AttributesKeyMap = Map[String, TextAttributesKey]()
}

class LiftColourSettingsPage extends ColorSettingsPage{

  override def getHighlighter: SyntaxHighlighter = {
    new LiftSyntaxHighlighter
  }

  override def getAdditionalHighlightingTagToDescriptorMap: java.util.Map[String, TextAttributesKey] = {
    LiftColourSettingsPage.AttributesKeyMap.asJava
  }

  override def getIcon: Icon = {
    LiftIcons.LiftLogo
  }

  override def getDemoText: String = {
    "import lift.opencl\n\n" +
      "def dotProduct(left: [n]float, right: [n]float) = {\n" +
      "    join() . mapWrg(\n" +
      "        join() . mapLcl(toGlobal(mapSeq(id)) . reduceSeq(add, 0.0) . mapSeq(mult)) . split(4)\n" +
      "    ) . split(1024) $ zip(left, right)\n" +
      "}"
  }

  override def getAttributeDescriptors: Array[AttributesDescriptor] = {
    LiftColourSettingsPage.Descriptors
  }

  override def getDisplayName: String = {
    "Lift"
  }

  override def getColorDescriptors: Array[ColorDescriptor] = {
    ColorDescriptor.EMPTY_ARRAY
  }
}
