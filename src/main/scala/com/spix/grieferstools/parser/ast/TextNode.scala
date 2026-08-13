package com.spix.grieferstools.parser.ast

import com.spix.grieferstools.visitor.IAstVisitor

/** Represents a literal text leaf node within the report template abstract syntax tree. */
final case class TextNode(text: String) extends IAstNode {
  override def accept[T](visitor: IAstVisitor[T]): T = visitor.visitText(this)
}
