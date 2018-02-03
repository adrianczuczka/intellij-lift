package intellij.lift.lexer

import scala.util.parsing.combinator.RegexParsers

object LiftLexer extends RegexParsers {

  def apply(code: String): Either[Unit, List[LiftToken]] = {
    parse(tokens, code) match {
      case NoSuccess(msg, next) => Left() //Left(LiftLexerError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def tokens: Parser[List[LiftToken]] = {
    phrase(rep1(include | definition | lpar | rpar | lbracket | rbracket | colon | lifttype
      | arrow | functionBody | integerValue | identifier)) ^^ { rawTokens => rawTokens}
  }

  def identifier: Parser[IDENTIFIER] = positioned {
    "[a-zA-Z_][a-zA-Z0-9_]*".r ^^ { str => IDENTIFIER(str) }
  }

  def integerValue: Parser[INTEGER_VALUE] = positioned {
    "[1-9][0-9]*".r  ^^{str => INTEGER_VALUE(str)}
  }

  def definition = positioned {"def"   ^^(_ => DEF())}
  def lpar = positioned {"("  ^^(_ => LPAR())}
  def rpar = positioned {")"  ^^(_ => RPAR())}
  def lbracket = positioned {"{"  ^^(_ => LBRACKET())}
  def rbracket = positioned {"}"  ^^(_ => RBRACKET())}
  def colon = positioned {":"  ^^(_ => COLON())}
  def lifttype = positioned {"int".r  ^^(str => TYPE(str))}
  def arrow = positioned {"=>".r  ^^(_ => ARROW())}
  def functionBody = positioned {"BODY" ^^(_ => FUNCTION_BODY())}
  def include = positioned {"include"   ^^(_ => INCLUDE())}
}
