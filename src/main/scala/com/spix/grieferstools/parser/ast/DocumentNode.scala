package com.spix.grieferstools.parser.ast

import com.spix.grieferstools.visitor.IAstVisitor

/** Represents the root composite node aggregating the ordered sequence of nodes within the report template abstract syntax tree. */
final case class DocumentNode(children: Seq[IAstNode]) extends IAstNode {
  override def accept[T](visitor: IAstVisitor[T]): T = visitor.visitDocument(this)
}
