package com.spix.grieferstools.parser.ast

import com.spix.grieferstools.visitor.IAstVisitor

/** Represents a substitutable placeholder leaf node within the report template abstract syntax tree. */
final case class PlaceholderNode(key: String) extends IAstNode {
  override def accept[T](visitor: IAstVisitor[T]): T = visitor.visitPlaceholder(this)
}
