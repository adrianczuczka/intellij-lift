package intellij.lift.formatting

import com.intellij.formatting._
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.TokenType
import java.util

class LiftBlock(node: ASTNode, wrap: Wrap, alignment: Alignment, spacingBuilder: SpacingBuilder) extends AbstractBlock(node, wrap, alignment) {

  protected override def buildChildren: util.List[Block] = {
    val blocks = new util.ArrayList[Block]
    var child = myNode.getFirstChildNode
    while (child != null) {
      if (child.getElementType != TokenType.WHITE_SPACE) {
        val block = new LiftBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment, spacingBuilder)
        blocks.add(block)
      }
      child = child.getTreeNext
    }
    //println(blocks)
    blocks
  }

  override def getIndent: Indent = Indent.getSmartIndent(Indent.Type.CONTINUATION)

  override def getSpacing(child1: Block, child2: Block): Spacing = spacingBuilder.getSpacing(this, child1, child2)

  override def isLeaf: Boolean = myNode.getFirstChildNode == null
}
