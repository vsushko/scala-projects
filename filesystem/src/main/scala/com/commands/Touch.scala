package com.commands

import com.files.{DirEntry, File}
import com.filesystem.State

/**
  *
  * @author vsushko
  */
class Touch(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
