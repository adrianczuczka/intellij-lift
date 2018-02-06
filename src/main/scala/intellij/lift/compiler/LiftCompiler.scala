package intellij.lift.compiler

import intellij.lift.lexer.{LiftLexer, LiftToken}
import intellij.lift.parser.{LiftAST, LiftParser}

object LiftCompiler {
  def apply(code: String)/*: Either[LiftCompilationError, LiftAST]*/ = {
//    for {
//      tokens <- LiftLexer(code).right
//      ast <- LiftParser(tokens).right
//    } yield ast
  }

  def main(args: Array[String]): Unit = {
    val validCode1 = "def doubleInput(int: x): int => { BODY }".stripMargin.trim
    println(apply(validCode1))

    val validCode2 = "include openCL_functions"
    println(apply(validCode2))

    val validCode3 = "doubleInput(28)"
    println(apply(validCode3))
  }
}