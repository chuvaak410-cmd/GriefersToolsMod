package com.spix.grieferstools.parser

import com.spix.grieferstools.parser.ast.DocumentNode
import com.spix.grieferstools.parser.lex.Token

/** Represents the foundational abstraction layer for recursive-descent parsing of report template token streams into an abstract syntax tree. */
trait IEnterpriseParser {
  def parse(tokens: Seq[Token]): DocumentNode
}
