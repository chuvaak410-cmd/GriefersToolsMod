package com.spix.grieferstools.visitor.impl

import com.spix.grieferstools.parser.ast.{DocumentNode, PlaceholderNode, TextNode}
import com.spix.grieferstools.visitor.IAstVisitor

/** Represents the concrete visitor implementation responsible for rendering the report template abstract syntax tree into a resolved string using a placeholder-value context map. */
class ReportRenderingVisitorImpl(private val context: Map[String, String]) extends IAstVisitor[String] {
  override def visitDocument(node: DocumentNode): String = node.children.map(_.accept(this)).mkString
  override def visitText(node: TextNode): String = node.text
  override def visitPlaceholder(node: PlaceholderNode): String = context.getOrElse(node.key, "")
}
