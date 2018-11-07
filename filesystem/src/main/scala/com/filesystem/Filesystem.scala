package com.filesystem

import java.util.Scanner

import com.commands.Command
import com.files.Directory

/**
  *
  * @author vsushko
  */
object Filesystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
}
