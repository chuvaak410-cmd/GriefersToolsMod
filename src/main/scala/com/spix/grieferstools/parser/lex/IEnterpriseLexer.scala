package com.spix.grieferstools.parser.lex

/** Represents the foundational abstraction layer for lexical analysis of report template source text. */
trait IEnterpriseLexer {
  def tokenize(source: String): Seq[Token]
}
