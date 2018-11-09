package com.commands

import com.filesystem.State

/**
  *
  * @author vsushko
  */
class Pwd extends Command {

  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
