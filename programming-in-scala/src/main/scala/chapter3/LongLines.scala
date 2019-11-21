package chapter3

import scala.io.Source

/**
  *
  * @author vsushko
  */
object LongLines {
  def processFile(filename: String, width: Int) = {
    def processLine(line: String) = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }
}