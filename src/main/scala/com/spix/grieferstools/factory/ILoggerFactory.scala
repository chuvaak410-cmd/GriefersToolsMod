package com.spix.grieferstools.factory

import com.spix.grieferstools.log.IEnterpriseLogger

/** Represents the foundational abstraction layer for logger instantiation concerns. */
trait ILoggerFactory {
  def create(tag: String): IEnterpriseLogger
}
