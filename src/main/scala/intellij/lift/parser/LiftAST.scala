package intellij.lift.parser

import scala.util.parsing.input.Positional

sealed trait LiftAST extends Positional
case class Include(source: String) extends LiftAST
case class Params(t1: String, id: String) extends LiftAST
case class Funcall(name: String, args: String) extends  LiftAST
case class Fundef(name: String, t1: String, value: String, output: String) extends LiftAST

