package com.commands

import com.filesystem.State

/**
  *
  * @author vsushko
  */
trait Command {

  def apply(state: State): State
}

object Command {

  def from(input: String): Command =
    new UnknownCommand
}

