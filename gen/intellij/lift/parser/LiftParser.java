// This is a generated file. Not intended for manual editing.
package intellij.lift.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static intellij.lift.psi.LiftTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LiftParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARGUMENTS) {
      r = arguments(b, 0);
    }
    else if (t == ARRAY_TYPE) {
      r = array_type(b, 0);
    }
    else if (t == BLOCK) {
      r = block(b, 0);
    }
    else if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == COMPOSED_FUNCALL) {
      r = composed_funcall(b, 0);
    }
    else if (t == EXP) {
      r = exp(b, 0);
    }
    else if (t == FUNCALL) {
      r = funcall(b, 0);
    }
    else if (t == FUNDEF) {
      r = fundef(b, 0);
    }
    else if (t == IDENT) {
      r = ident(b, 0);
    }
    else if (t == IMPORT) {
      r = import_$(b, 0);
    }
    else if (t == PARAM) {
      r = param(b, 0);
    }
    else if (t == PARAMS) {
      r = params(b, 0);
    }
    else if (t == STMT) {
      r = stmt(b, 0);
    }
    else if (t == SYMBOL) {
      r = symbol(b, 0);
    }
    else if (t == TUPLE_TYPE) {
      r = tuple_type(b, 0);
    }
    else if (t == TYP) {
      r = typ(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else if (t == VARDEF) {
      r = vardef(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // funcall
  //                       | IDENTIFIER
  //                       | value
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, "<arguments>");
    r = funcall(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ARRAY LEFT_PAREN typ COMMA (ident | NUMERIC_VALUE) RIGHT_PAREN
  //                       | (LEFT_BRACKET (IDENTIFIER | NUMERIC_VALUE)? RIGHT_BRACKET)+ TYPE
  public static boolean array_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type")) return false;
    if (!nextTokenIs(b, "<array type>", ARRAY, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_TYPE, "<array type>");
    r = array_type_0(b, l + 1);
    if (!r) r = array_type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ARRAY LEFT_PAREN typ COMMA (ident | NUMERIC_VALUE) RIGHT_PAREN
  private static boolean array_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ARRAY, LEFT_PAREN);
    r = r && typ(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && array_type_0_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ident | NUMERIC_VALUE
  private static boolean array_type_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_0_4")) return false;
    boolean r;
    r = ident(b, l + 1);
    if (!r) r = consumeToken(b, NUMERIC_VALUE);
    return r;
  }

  // (LEFT_BRACKET (IDENTIFIER | NUMERIC_VALUE)? RIGHT_BRACKET)+ TYPE
  private static boolean array_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_type_1_0(b, l + 1);
    r = r && consumeToken(b, TYPE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LEFT_BRACKET (IDENTIFIER | NUMERIC_VALUE)? RIGHT_BRACKET)+
  private static boolean array_type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_type_1_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!array_type_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_type_1_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACKET (IDENTIFIER | NUMERIC_VALUE)? RIGHT_BRACKET
  private static boolean array_type_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && array_type_1_0_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IDENTIFIER | NUMERIC_VALUE)?
  private static boolean array_type_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0_0_1")) return false;
    array_type_1_0_0_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER | NUMERIC_VALUE
  private static boolean array_type_1_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMERIC_VALUE);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE GAP* (stmt)* (APPLICATOR arguments)? GAP* RIGHT_BRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && block_1(b, l + 1);
    r = r && block_2(b, l + 1);
    r = r && block_3(b, l + 1);
    r = r && block_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // GAP*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, GAP)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
    }
    return true;
  }

  // (stmt)*
  private static boolean block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_2", c)) break;
    }
    return true;
  }

  // (stmt)
  private static boolean block_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (APPLICATOR arguments)?
  private static boolean block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_3")) return false;
    block_3_0(b, l + 1);
    return true;
  }

  // APPLICATOR arguments
  private static boolean block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, APPLICATOR);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GAP*
  private static boolean block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, GAP)) break;
      if (!empty_element_parsed_guard_(b, "block_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LINE_COMMENT | BLOCK_COMMENT | NOT_TERMINATED_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    if (!r) r = consumeToken(b, NOT_TERMINATED_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // funcall COMPOSER funcall (COMPOSER funcall)*
  public static boolean composed_funcall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "composed_funcall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = funcall(b, l + 1);
    r = r && consumeToken(b, COMPOSER);
    r = r && funcall(b, l + 1);
    r = r && composed_funcall_3(b, l + 1);
    exit_section_(b, m, COMPOSED_FUNCALL, r);
    return r;
  }

  // (COMPOSER funcall)*
  private static boolean composed_funcall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "composed_funcall_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!composed_funcall_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "composed_funcall_3", c)) break;
    }
    return true;
  }

  // COMPOSER funcall
  private static boolean composed_funcall_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "composed_funcall_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPOSER);
    r = r && funcall(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN exp RIGHT_PAREN
  //                       | composed_funcall
  //                       | funcall
  //                       | value
  //                       | symbol
  //                       | vardef
  //                       | IDENTIFIER
  public static boolean exp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXP, "<exp>");
    r = exp_0(b, l + 1);
    if (!r) r = composed_funcall(b, l + 1);
    if (!r) r = funcall(b, l + 1);
    if (!r) r = value(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = vardef(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_PAREN exp RIGHT_PAREN
  private static boolean exp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER LEFT_PAREN (GAP)? [ exp (COMMA exp)* ] (GAP)? RIGHT_PAREN SEMI_COLON
  public static boolean funcall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LEFT_PAREN);
    r = r && funcall_2(b, l + 1);
    r = r && funcall_3(b, l + 1);
    r = r && funcall_4(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_PAREN, SEMI_COLON);
    exit_section_(b, m, FUNCALL, r);
    return r;
  }

  // (GAP)?
  private static boolean funcall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall_2")) return false;
    consumeToken(b, GAP);
    return true;
  }

  // [ exp (COMMA exp)* ]
  private static boolean funcall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall_3")) return false;
    funcall_3_0(b, l + 1);
    return true;
  }

  // exp (COMMA exp)*
  private static boolean funcall_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exp(b, l + 1);
    r = r && funcall_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA exp)*
  private static boolean funcall_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!funcall_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "funcall_3_0_1", c)) break;
    }
    return true;
  }

  // COMMA exp
  private static boolean funcall_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (GAP)?
  private static boolean funcall_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall_4")) return false;
    consumeToken(b, GAP);
    return true;
  }

  /* ********************************************************** */
  // DEFINITION ident LEFT_PAREN params RIGHT_PAREN (COLON typ)? EQUAL block (GAP)?
  public static boolean fundef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fundef")) return false;
    if (!nextTokenIs(b, DEFINITION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINITION);
    r = r && ident(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && params(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && fundef_5(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && block(b, l + 1);
    r = r && fundef_8(b, l + 1);
    exit_section_(b, m, FUNDEF, r);
    return r;
  }

  // (COLON typ)?
  private static boolean fundef_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fundef_5")) return false;
    fundef_5_0(b, l + 1);
    return true;
  }

  // COLON typ
  private static boolean fundef_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fundef_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && typ(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (GAP)?
  private static boolean fundef_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fundef_8")) return false;
    consumeToken(b, GAP);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ident")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT_KEYWORD IMPORTABLE GAP
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, IMPORT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT_KEYWORD, IMPORTABLE, GAP);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  /* ********************************************************** */
  // ident COLON typ
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && typ(b, l + 1);
    exit_section_(b, m, PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // [ param (COMMA param)* ]
  public static boolean params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params")) return false;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    params_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // param (COMMA param)*
  private static boolean params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param(b, l + 1);
    r = r && params_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA param)*
  private static boolean params_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "params_0_1", c)) break;
    }
    return true;
  }

  // COMMA param
  private static boolean params_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (import)* (fundef)*
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_0(b, l + 1);
    r = r && program_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (import)*
  private static boolean program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!program_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_0", c)) break;
    }
    return true;
  }

  // (import)
  private static boolean program_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_$(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (fundef)*
  private static boolean program_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!program_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_1", c)) break;
    }
    return true;
  }

  // (fundef)
  private static boolean program_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fundef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // exp SEMI_COLON GAP*
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STMT, "<stmt>");
    r = exp(b, l + 1);
    r = r && consumeToken(b, SEMI_COLON);
    r = r && stmt_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // GAP*
  private static boolean stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, GAP)) break;
      if (!empty_element_parsed_guard_(b, "stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPERATION
  public static boolean symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbol")) return false;
    if (!nextTokenIs(b, OPERATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATION);
    exit_section_(b, m, SYMBOL, r);
    return r;
  }

  /* ********************************************************** */
  // TUPLE LEFT_PAREN exp COMMA exp+ RIGHT_PAREN
  public static boolean tuple_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_type")) return false;
    if (!nextTokenIs(b, TUPLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TUPLE, LEFT_PAREN);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && tuple_type_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, TUPLE_TYPE, r);
    return r;
  }

  // exp+
  private static boolean tuple_type_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_type_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exp(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!exp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_type_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE | array_type | tuple_type
  public static boolean typ(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typ")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYP, "<typ>");
    r = consumeToken(b, TYPE);
    if (!r) r = array_type(b, l + 1);
    if (!r) r = tuple_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NUMERIC_VALUE | BOOLEAN
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    if (!nextTokenIs(b, "<value>", BOOLEAN, NUMERIC_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, NUMERIC_VALUE);
    if (!r) r = consumeToken(b, BOOLEAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUAL exp SEMI_COLON
  public static boolean vardef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vardef")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUAL);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, SEMI_COLON);
    exit_section_(b, m, VARDEF, r);
    return r;
  }

}
