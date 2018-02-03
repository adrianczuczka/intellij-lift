package intellij.lift.parser

import intellij.lift.compiler.{LiftParserError, Location}
import intellij.lift.lexer._

import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.{NoPosition, Position, Reader}

object LiftParser extends Parsers {
  override type Elem = LiftToken

  class LiftTokenReader(tokens: Seq[LiftToken]) extends Reader[LiftToken] {
    override def first: LiftToken = tokens.head
    override def atEnd: Boolean = tokens.isEmpty
    override def pos: Position = tokens.headOption.map(_.pos).getOrElse(NoPosition)
    override def rest: Reader[LiftToken] = new LiftTokenReader(tokens.tail)
  }

  def apply(tokens: Seq[LiftToken]): Either[LiftParserError, LiftAST] = {
    val reader = new LiftTokenReader(tokens)
    program(reader) match {
      case NoSuccess(msg, next) => Left(LiftParserError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def program: Parser[LiftAST] = positioned {
    phrase(statement)
  }

  def statement: Parser[LiftAST] = positioned {
    include | funcall | fundef
  }

  def include: Parser[Include] = positioned {
    (INCLUDE() ~ identifier) ^^ {case _ ~ IDENTIFIER(source) => Include(source)}
  }

  def funcall: Parser[Funcall] = positioned{
    (identifier ~ LPAR() ~ integerValue ~ RPAR()) ^^ {case IDENTIFIER(id) ~ _ ~ INTEGER_VALUE(args) ~ _=> Funcall(id, args)}
  }
  def fundef: Parser[Fundef] = positioned {
    (DEF() ~ identifier ~ LPAR() ~ params ~ RPAR() ~ COLON() ~ TYPE("int") ~ ARROW() ~ LBRACKET() ~ FUNCTION_BODY() ~ RBRACKET()) ^^ {
      case _ ~ IDENTIFIER(id) ~ _ ~ Params(t1, value) ~ _ ~ _ ~ TYPE(output) ~ _ ~ _ ~ _ ~ _ =>
        Fundef(id, t1, value, output)
    }
  }

  def params: Parser[Params] = positioned {
    (TYPE("int") ~ COLON() ~ identifier) ^^ {
      case TYPE(t1) ~ _ ~ IDENTIFIER(id) => Params(t1, id)
    }
  }

  private def identifier: Parser[IDENTIFIER] = positioned {
    accept("identifier", { case id@IDENTIFIER(name) => id })
  }
  private def integerValue: Parser[INTEGER_VALUE] = positioned {
    accept("integerValue", { case id @ INTEGER_VALUE(value) => id })
  }
}
