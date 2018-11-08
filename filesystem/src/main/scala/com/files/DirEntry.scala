package com.files

/**
  *
  * @author vsushko
  */
abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = parentPath + Directory.SEPARATOR + name

  def asDirectory: Directory

  def getType: String
}
