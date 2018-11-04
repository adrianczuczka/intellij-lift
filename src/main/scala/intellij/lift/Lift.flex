package intellij.lift;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import intellij.lift.psi.LiftTypes;
import com.intellij.psi.TokenType;import static intellij.lift.psi.LiftTypes.BLOCK_COMMENT;import static intellij.lift.psi.LiftTypes.NOT_TERMINATED_COMMENT;

%%

%class LiftLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}
%xstate L_BLOCK_COMMENT

%{
    private int commentStart;
%}

newline             = \r|\n|\r\n
unispace            = \x05
white_char          = [\ \t\f\x0B\ \x0D ] | {unispace}
white_space         = {white_char}+

gap                 = ({white_space}|{newline})*
importable          = "lift." {identifier}

left_paren          = "("
right_paren         = ")"
left_brace          = "{"
right_brace         = "}"
left_bracket        = "["
right_bracket       = "]"
equal               = "="
colon               = ":"
comma               = ","
composer            = "."
applicator          = "$"
slash               = "/"
star                = "*"

add                 = "+"
subtract            = "-"
multiply            = "*"
divide              = "/"
operation           = {add} | {subtract} | {multiply} | {divide}


small               = [a-z_]
large               = [A-Z]
digit               = [0-9]

int                 = [-]?[1-9]{digit}*
float               = [-+]?([0-9]+(\.[0-9]*)?|\.[0-9]+)([eE][-+]?[0-9]+)?
double              = [-+]?([0-9]+(\.[0-9]*)?|\.[0-9]+)
true                = "true"
false               = "false"
bool                = {true} | {false}
numeric_value       = {int} | {double} | {float}


int_type            = "int"
double_type         = "double"
float_type          = "float"
bool_type           = "bool"
array               = "Array"
tuple               = "Tuple"
type                = {int_type} | {bool_type} | {float_type} | {double_type}

identifier          = {small} ({small} | {large} | {digit})*

line_comment        = {slash}{slash}[^\r\n]*
block_comment_start = {slash}{star}
block_comment_end   = {star}{slash}

%%

<L_BLOCK_COMMENT> {

    <<EOF>> {
            int state = yystate();
            yybegin(YYINITIAL);
            zzStartRead = commentStart;
            return NOT_TERMINATED_COMMENT;
      }

    {block_comment_end} {
            int state = yystate();
            yybegin(YYINITIAL);
            zzStartRead = commentStart;
            return BLOCK_COMMENT;
      }

    .|{white_char}|{newline} {}
}

{block_comment_start} {
    yybegin(L_BLOCK_COMMENT);
    commentStart = getTokenStart();
}

{line_comment}                      { return LiftTypes.LINE_COMMENT; }

{white_space}                       { return TokenType.WHITE_SPACE; }

{gap}                               { return LiftTypes.GAP; }

"import"                            { return LiftTypes.IMPORT_KEYWORD; }
{array}                             { return LiftTypes.ARRAY; }
{tuple}                             { return LiftTypes.TUPLE; }

{importable}                        { return LiftTypes.IMPORTABLE; }

"def"                               { return LiftTypes.DEFINITION; }

{left_paren}                        { return LiftTypes.LEFT_PAREN; }
{right_paren}                       { return LiftTypes.RIGHT_PAREN; }
{left_brace}                        { return LiftTypes.LEFT_BRACE; }
{right_brace}                       { return LiftTypes.RIGHT_BRACE; }
{left_bracket}                      { return LiftTypes.LEFT_BRACKET; }
{right_bracket}                     { return LiftTypes.RIGHT_BRACKET; }
{comma}                             { return LiftTypes.COMMA; }
{colon}                             { return LiftTypes.COLON; }
{equal}                             { return LiftTypes.EQUAL; }
{composer}                          { return LiftTypes.COMPOSER; }
{applicator}                        { return LiftTypes.APPLICATOR; }
{type}                              { return LiftTypes.TYPE; }
{operation}                         { return LiftTypes.OPERATION; }

{bool}                              { return LiftTypes.BOOLEAN; }
{numeric_value}                     { return LiftTypes.NUMERIC_VALUE; }
{identifier}                        { return LiftTypes.IDENTIFIER; }

[^]                                 { return TokenType.BAD_CHARACTER; }