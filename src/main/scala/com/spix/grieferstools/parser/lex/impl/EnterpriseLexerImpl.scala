package com.spix.grieferstools.parser.lex.impl

import com.spix.grieferstools.parser.lex.{IEnterpriseLexer, Token, TokenType}

import scala.collection.mutable.ArrayBuffer

/** Represents the concrete recursive-scanning implementation of the report template lexer, recognizing `{placeholder}` tokens embedded in literal text. */
class EnterpriseLexerImpl extends IEnterpriseLexer {
  override def tokenize(source: String): Seq[Token] = {
    val tokens = ArrayBuffer[Token]()
    val textBuffer = new StringBuilder
    var i = 0
    while (i < source.length) {
      val c = source.charAt(i)
      if (c == '{') {
        val end = source.indexOf('}', i)
        if (end < 0) {
          textBuffer.append(c)
          i += 1
        } else {
          if (textBuffer.nonEmpty) {
            tokens += Token(TokenType.Text, textBuffer.toString())
            textBuffer.clear()
          }
          tokens += Token(TokenType.Placeholder, source.substring(i + 1, end))
          i = end + 1
        }
      } else {
        textBuffer.append(c)
        i += 1
      }
    }
    if (textBuffer.nonEmpty) tokens += Token(TokenType.Text, textBuffer.toString())
    tokens += Token(TokenType.EndOfFile, "")
    tokens.toSeq
  }
}
