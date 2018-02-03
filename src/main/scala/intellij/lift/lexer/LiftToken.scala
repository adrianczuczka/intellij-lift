package intellij.lift.lexer

import scala.util.parsing.input.Positional

sealed trait LiftToken extends Positional

// list of Lift key tokens to be recognised
case class IDENTIFIER(str: String) extends LiftToken
case class INTEGER_VALUE(str: String) extends LiftToken
case class FUNCTION_BODY() extends LiftToken
case class TYPE(str: String) extends LiftToken
case class ARROW() extends LiftToken
case class DEF() extends LiftToken
case class LPAR() extends LiftToken
case class RPAR() extends LiftToken
case class LBRACKET() extends LiftToken
case class RBRACKET() extends LiftToken
case class COLON() extends LiftToken
case class INCLUDE() extends LiftToken
case class PARAMS() extends LiftToken
