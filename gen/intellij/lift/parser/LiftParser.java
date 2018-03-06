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
    else if (t == PARAMS) {
      r = params(b, 0);
    }
    else if (t == STMT) {
      r = stmt(b, 0);
    }
    else if (t == TYP) {
      r = typ(b, 0);
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
  //             | IDENTIFIER
  //             | VALUE
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    if (!nextTokenIs(b, "<arguments>", IDENTIFIER, VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, "<arguments>");
    r = funcall(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ARRAY LEFT_PAREN typ COMMA (ident | VALUE) RIGHT_PAREN
  //              | (LEFT_BRACKET (IDENTIFIER | VALUE)? RIGHT_BRACKET)* TYPE
  public static boolean array_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_TYPE, "<array type>");
    r = array_type_0(b, l + 1);
    if (!r) r = array_type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ARRAY LEFT_PAREN typ COMMA (ident | VALUE) RIGHT_PAREN
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

  // ident | VALUE
  private static boolean array_type_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LEFT_BRACKET (IDENTIFIER | VALUE)? RIGHT_BRACKET)* TYPE
  private static boolean array_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_type_1_0(b, l + 1);
    r = r && consumeToken(b, TYPE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LEFT_BRACKET (IDENTIFIER | VALUE)? RIGHT_BRACKET)*
  private static boolean array_type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!array_type_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_type_1_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // LEFT_BRACKET (IDENTIFIER | VALUE)? RIGHT_BRACKET
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

  // (IDENTIFIER | VALUE)?
  private static boolean array_type_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0_0_1")) return false;
    array_type_1_0_0_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER | VALUE
  private static boolean array_type_1_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE GAP (stmt)* (APPLICATOR arguments)? GAP RIGHT_BRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_BRACE, GAP);
    r = r && block_2(b, l + 1);
    r = r && block_3(b, l + 1);
    r = r && consumeTokens(b, 0, GAP, RIGHT_BRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // (stmt)*
  private static boolean block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!block_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_2", c)) break;
      c = current_position_(b);
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
    int c = current_position_(b);
    while (true) {
      if (!composed_funcall_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "composed_funcall_3", c)) break;
      c = current_position_(b);
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
  //              | composed_funcall
  //              | funcall
  //              | IDENTIFIER
  //              | VALUE
  public static boolean exp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXP, "<exp>");
    r = exp_0(b, l + 1);
    if (!r) r = composed_funcall(b, l + 1);
    if (!r) r = funcall(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VALUE);
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
  // IDENTIFIER LEFT_PAREN (GAP)? [ exp (COMMA exp)* ] (GAP)? RIGHT_PAREN
  public static boolean funcall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LEFT_PAREN);
    r = r && funcall_2(b, l + 1);
    r = r && funcall_3(b, l + 1);
    r = r && funcall_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
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
    int c = current_position_(b);
    while (true) {
      if (!funcall_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "funcall_3_0_1", c)) break;
      c = current_position_(b);
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
  // [ ident COLON typ (COMMA ident COLON typ)* ]
  public static boolean params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params")) return false;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    params_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // ident COLON typ (COMMA ident COLON typ)*
  private static boolean params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && typ(b, l + 1);
    r = r && params_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA ident COLON typ)*
  private static boolean params_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!params_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "params_0_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA ident COLON typ
  private static boolean params_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ident(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && typ(b, l + 1);
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
    int c = current_position_(b);
    while (true) {
      if (!program_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_0", c)) break;
      c = current_position_(b);
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
    int c = current_position_(b);
    while (true) {
      if (!program_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_1", c)) break;
      c = current_position_(b);
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
  // exp
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STMT, "<stmt>");
    r = exp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TYPE | array_type
  public static boolean typ(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typ")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYP, "<typ>");
    r = consumeToken(b, TYPE);
    if (!r) r = array_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
