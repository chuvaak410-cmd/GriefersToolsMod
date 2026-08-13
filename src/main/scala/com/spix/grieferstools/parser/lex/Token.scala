package com.spix.grieferstools.parser.lex

/** Represents an immutable lexical token produced by the report template lexer. */
final case class Token(tokenType: TokenType, lexeme: String)
