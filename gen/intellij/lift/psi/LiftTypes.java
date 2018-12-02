// This is a generated file. Not intended for manual editing.
package intellij.lift.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.lift.psi.impl.*;

public interface LiftTypes {

  IElementType ARGUMENTS = new LiftElementType("ARGUMENTS");
  IElementType ARRAY_TYPE = new LiftElementType("ARRAY_TYPE");
  IElementType BLOCK = new LiftElementType("BLOCK");
  IElementType COMMENT = new LiftElementType("COMMENT");
  IElementType COMPOSED_FUNCALL = new LiftElementType("COMPOSED_FUNCALL");
  IElementType EXP = new LiftElementType("EXP");
  IElementType FUNCALL = new LiftElementType("FUNCALL");
  IElementType FUNDEF = new LiftElementType("FUNDEF");
  IElementType IDENT = new LiftElementType("IDENT");
  IElementType IMPORT = new LiftElementType("IMPORT");
  IElementType PARAM = new LiftElementType("PARAM");
  IElementType PARAMS = new LiftElementType("PARAMS");
  IElementType STMT = new LiftElementType("STMT");
  IElementType SYMBOL = new LiftElementType("SYMBOL");
  IElementType TUPLE_TYPE = new LiftElementType("TUPLE_TYPE");
  IElementType TYP = new LiftElementType("TYP");
  IElementType VALUE = new LiftElementType("VALUE");
  IElementType VARDEF = new LiftElementType("VARDEF");

  IElementType APPLICATOR = new LiftTokenType("APPLICATOR");
  IElementType ARRAY = new LiftTokenType("ARRAY");
  IElementType BLOCK_COMMENT = new LiftTokenType("BLOCK_COMMENT");
  IElementType BOOLEAN = new LiftTokenType("BOOLEAN");
  IElementType COLON = new LiftTokenType("COLON");
  IElementType COMMA = new LiftTokenType("COMMA");
  IElementType COMPOSER = new LiftTokenType("COMPOSER");
  IElementType DEFINITION = new LiftTokenType("DEFINITION");
  IElementType EQUAL = new LiftTokenType("EQUAL");
  IElementType GAP = new LiftTokenType("GAP");
  IElementType IDENTIFIER = new LiftTokenType("IDENTIFIER");
  IElementType IMPORTABLE = new LiftTokenType("IMPORTABLE");
  IElementType IMPORT_KEYWORD = new LiftTokenType("IMPORT_KEYWORD");
  IElementType LEFT_BRACE = new LiftTokenType("LEFT_BRACE");
  IElementType LEFT_BRACKET = new LiftTokenType("LEFT_BRACKET");
  IElementType LEFT_PAREN = new LiftTokenType("LEFT_PAREN");
  IElementType LINE_COMMENT = new LiftTokenType("LINE_COMMENT");
  IElementType NOT_TERMINATED_COMMENT = new LiftTokenType("NOT_TERMINATED_COMMENT");
  IElementType NUMERIC_VALUE = new LiftTokenType("NUMERIC_VALUE");
  IElementType OPERATION = new LiftTokenType("OPERATION");
  IElementType RIGHT_BRACE = new LiftTokenType("RIGHT_BRACE");
  IElementType RIGHT_BRACKET = new LiftTokenType("RIGHT_BRACKET");
  IElementType RIGHT_PAREN = new LiftTokenType("RIGHT_PAREN");
  IElementType SEMI_COLON = new LiftTokenType("SEMI_COLON");
  IElementType TUPLE = new LiftTokenType("TUPLE");
  IElementType TYPE = new LiftTokenType("TYPE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGUMENTS) {
        return new LiftArgumentsImpl(node);
      }
      else if (type == ARRAY_TYPE) {
        return new LiftArrayTypeImpl(node);
      }
      else if (type == BLOCK) {
        return new LiftBlockImpl(node);
      }
      else if (type == COMMENT) {
        return new LiftCommentImpl(node);
      }
      else if (type == COMPOSED_FUNCALL) {
        return new LiftComposedFuncallImpl(node);
      }
      else if (type == EXP) {
        return new LiftExpImpl(node);
      }
      else if (type == FUNCALL) {
        return new LiftFuncallImpl(node);
      }
      else if (type == FUNDEF) {
        return new LiftFundefImpl(node);
      }
      else if (type == IDENT) {
        return new LiftIdentImpl(node);
      }
      else if (type == IMPORT) {
        return new LiftImportImpl(node);
      }
      else if (type == PARAM) {
        return new LiftParamImpl(node);
      }
      else if (type == PARAMS) {
        return new LiftParamsImpl(node);
      }
      else if (type == STMT) {
        return new LiftStmtImpl(node);
      }
      else if (type == SYMBOL) {
        return new LiftSymbolImpl(node);
      }
      else if (type == TUPLE_TYPE) {
        return new LiftTupleTypeImpl(node);
      }
      else if (type == TYP) {
        return new LiftTypImpl(node);
      }
      else if (type == VALUE) {
        return new LiftValueImpl(node);
      }
      else if (type == VARDEF) {
        return new LiftVardefImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
