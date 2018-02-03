package intellij.lift.compiler

sealed trait LiftCompilationError

case class LiftLexerError(location: Location, msg: String) extends LiftCompilationError
case class LiftParserError(location: Location, msg: String) extends LiftCompilationError

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}
