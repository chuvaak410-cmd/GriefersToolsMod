package com.spix.grieferstools.visitor

import com.spix.grieferstools.parser.ast.{DocumentNode, PlaceholderNode, TextNode}

/** Represents the foundational abstraction layer for the Visitor pattern applied to the report template abstract syntax tree. */
trait IAstVisitor[T] {
  def visitDocument(node: DocumentNode): T
  def visitText(node: TextNode): T
  def visitPlaceholder(node: PlaceholderNode): T
}
