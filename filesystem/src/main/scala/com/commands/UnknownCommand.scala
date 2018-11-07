package com.commands

import com.filesystem.State

/**
  *
  * @author vsushko
  */
class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("Command not found!")
}

