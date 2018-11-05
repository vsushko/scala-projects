package lectures.part1basics

/**
  *
  * @author vsushko
  */
object DefaultArgs extends App {

  val fact10 = trFact(10)

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  // the second parameter will be overridden
  // val fact10 = trFact(10, 2)

  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  // leads to error
  // savePicture(800, 600)
  // savePicture(800)
  savePicture(width = 800)

  // possible solutions:
  // 1. pass in every leading argument
  // 2. name the arguments

  savePicture(height = 600, width = 800, format = "bmp")
}
