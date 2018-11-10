package com.filesystem

import com.commands.Command
import com.files.Directory

/**
  *
  * @author vsushko
  */
object Filesystem extends App {

  val root = Directory.ROOT
  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    currentState.show
    Command.from(newLine).apply(currentState)
  })
}
