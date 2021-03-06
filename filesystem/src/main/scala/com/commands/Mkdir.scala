package com.commands

import com.files.{DirEntry, Directory}
import com.filesystem.State

/**
  *
  * @author vsushko
  */
class Mkdir(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
