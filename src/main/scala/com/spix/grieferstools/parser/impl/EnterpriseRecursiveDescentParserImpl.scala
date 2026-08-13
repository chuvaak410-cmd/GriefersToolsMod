package com.spix.grieferstools.parser.impl

import com.spix.grieferstools.parser.IEnterpriseParser
import com.spix.grieferstools.parser.ast.{DocumentNode, IAstNode, PlaceholderNode, TextNode}
import com.spix.grieferstools.parser.lex.{Token, TokenType}

import scala.collection.mutable.ArrayBuffer

/** Represents the concrete recursive-descent parser implementation that consumes a lexical token stream and produces the report template abstract syntax tree. */
class EnterpriseRecursiveDescentParserImpl extends IEnterpriseParser {
  override def parse(tokens: Seq[Token]): DocumentNode = {
    val children = ArrayBuffer[IAstNode]()
    var i = 0
    while (i < tokens.length && tokens(i).tokenType != TokenType.EndOfFile) {
      tokens(i).tokenType match {
        case TokenType.Text        => children += TextNode(tokens(i).lexeme)
        case TokenType.Placeholder => children += PlaceholderNode(tokens(i).lexeme)
        case _                     => ()
      }
      i += 1
    }
    DocumentNode(children.toSeq)
  }
}
