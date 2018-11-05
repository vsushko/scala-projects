package lectures.part1basics

import playground.Cinderella


/**
  *
  * @author vsushko
  */
object PackagingAndImports extends App {

  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // playground.Cinderella = fully qualified name
  val princess = new Cinderella

  // packages are in hierarchy
  // matching folder structure

  // package object


}

class Writer(str: String, str1: String, i: Int)


