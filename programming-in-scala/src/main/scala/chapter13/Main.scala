package chapter13

/**
  *
  * @author vsushko
  */
object Main {

  def main(args: Array[String]) = {

  }
}

class Rocket {

  import Rocket.fuel

  private def canGoHomeAgain = fuel > 20
}

object Rocket {
  private def fuel = 10

  def chooseStrategy(rocket: Rocket) = {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()
  }

  def goHome() = {}

  def pickAStar() = {}
}