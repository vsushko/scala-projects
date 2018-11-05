package lectures.part2oop

import java.sql.{Date => SqlDate}
import java.util.Date

import lectures.part2oop.OOBasics.Writer
import playground.{Cinderella, PrinceCharming}

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
  sayHello

  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4)

  // 2. using aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}

