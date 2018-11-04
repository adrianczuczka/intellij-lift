package intellij.lift

import javax.swing.Icon

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.{FileType, FileTypeConsumer, FileTypeFactory, LanguageFileType}
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

class LiftFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, LiftLanguage.Instance){

  @NotNull
  override def getFileType: FileType = {
    LiftFileType.Instance
  }

  override def toString: String = {
    "Lift file"
  }

  override def getIcon(flags: Int): Icon = {
    super.getIcon(flags)
  }
}

object LiftFileType {
  final val Instance: LiftFileType = new LiftFileType

  final val LiftFileExtension = "lift"
}

class LiftFileType extends LanguageFileType(LiftLanguage.Instance){

  override def getName: String = {
    "Lift File"
  }

  override def getDescription: String = {
    "Lift language file"
  }

  override def getDefaultExtension: String = {
    "lift"
  }

  override def getIcon: Icon = {
    LiftIcons.LiftLogo
  }

}

class LiftFileTypeFactory extends FileTypeFactory{
  override def createFileTypes(fileTypeConsumer: FileTypeConsumer): Unit = {
    fileTypeConsumer.consume(LiftFileType.Instance, LiftFileType.Instance.getDefaultExtension)
  }

}
