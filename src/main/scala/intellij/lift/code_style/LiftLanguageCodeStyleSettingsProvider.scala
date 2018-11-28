package intellij.lift.code_style

import com.intellij.lang.Language
import com.intellij.psi.codeStyle.{CodeStyleSettingsCustomizable, CommonCodeStyleSettings, LanguageCodeStyleSettingsProvider}
import intellij.lift.LiftLanguage
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider.SettingsType

class LiftLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

  override def getLanguage: Language = LiftLanguage.Instance

  override def getDefaultCommonSettings: CommonCodeStyleSettings = {
    val defaultSettings = new CommonCodeStyleSettings(getLanguage)
    val indentOptions = defaultSettings.initIndentOptions
    indentOptions.INDENT_SIZE = 4
    indentOptions.CONTINUATION_INDENT_SIZE = 8
    indentOptions.TAB_SIZE = 4
    indentOptions.USE_TAB_CHARACTER = true
    defaultSettings.LINE_COMMENT_AT_FIRST_COLUMN = false
    defaultSettings.KEEP_FIRST_COLUMN_COMMENT = false
    defaultSettings
  }

  override def customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: LanguageCodeStyleSettingsProvider.SettingsType): Unit = {
    if (settingsType == SettingsType.SPACING_SETTINGS) {
      consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS")
      consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Separator")
    }
    else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE")
  }

  override def getCodeSample(settingsType: LanguageCodeStyleSettingsProvider.SettingsType): String =
    "// You are reading the \".properties\" entry.\n" +
      "/* This is a block comment. */ \n" +
      "import lift.opencl \n" + "" +
      "def test(left : int) = {\n    add(2, 2)\n}"
}
