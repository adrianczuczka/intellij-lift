package intellij.lift.highlighter

import java.util
import javax.swing.Icon

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}

object LiftColourSettingsPage{
  private final val Descriptors = Array[AttributesDescriptor](
    // TODO: Initialise the descriptors in this array
  )
  private final val AttributesKeyMap = Map[String, TextAttributesKey]()
}

class LiftColourSettingsPage extends ColorSettingsPage{
  // TODO: Implement unimplemented methods from the interface

  override def getHighlighter: SyntaxHighlighter = ???

  override def getAdditionalHighlightingTagToDescriptorMap: util.Map[String, TextAttributesKey] = ???

  override def getIcon: Icon = ???

  override def getDemoText: String = ???

  override def getAttributeDescriptors: Array[AttributesDescriptor] = ???

  override def getDisplayName: String = ???

  override def getColorDescriptors: Array[ColorDescriptor] = ???
}
