package com.spix.grieferstools.parser.lex

/** Represents the exhaustive enumeration of lexical token classifications recognized by the report template lexer. */
sealed trait TokenType
object TokenType {
  case object Text extends TokenType
  case object Placeholder extends TokenType
  case object EndOfFile extends TokenType
}
