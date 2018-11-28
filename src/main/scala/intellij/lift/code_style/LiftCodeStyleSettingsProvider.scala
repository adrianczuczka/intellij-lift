package intellij.lift.code_style

import com.intellij.openapi.options.Configurable
import com.intellij.psi.codeStyle.{CodeStyleSettingsProvider, CustomCodeStyleSettings}
import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings
import intellij.lift.LiftLanguage

class LiftCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
  override def createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings = new LiftCodeStyleSettings(settings)

  override def getConfigurableDisplayName: String = "Lift"

  override def createSettingsPage(settings: CodeStyleSettings, originalSettings: CodeStyleSettings): Configurable = {
    new CodeStyleAbstractConfigurable(settings, originalSettings, "Lift") {
      override protected def createPanel(settings: CodeStyleSettings) = new LiftCodeStyleMainPanel(getCurrentSettings, settings)

      override def getHelpTopic: String = null
    }
  }

  private class LiftCodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings)
    extends TabbedLanguageCodeStylePanel(LiftLanguage.Instance, currentSettings, settings) {
  }

}
