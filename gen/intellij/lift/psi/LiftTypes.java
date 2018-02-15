// This is a generated file. Not intended for manual editing.
package intellij.lift.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import intellij.lift.psi.impl.*;

public interface LiftTypes {

  IElementType PROPERTY = new LiftElementType("PROPERTY");

  IElementType COMMENT = new LiftTokenType("COMMENT");
  IElementType CRLF = new LiftTokenType("CRLF");
  IElementType KEY = new LiftTokenType("KEY");
  IElementType SEPARATOR = new LiftTokenType("SEPARATOR");
  IElementType VALUE = new LiftTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new LiftPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
