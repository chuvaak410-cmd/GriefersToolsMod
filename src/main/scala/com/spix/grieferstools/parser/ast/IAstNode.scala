package com.spix.grieferstools.parser.ast

import com.spix.grieferstools.visitor.IAstVisitor

/** Represents the foundational abstraction layer for all nodes participating in the report template abstract syntax tree. */
trait IAstNode {
  def accept[T](visitor: IAstVisitor[T]): T
}
