package bobsrockets {
  package navigation {

    class Navigator {
      val map = new StarMap
    }

    class StarMap

    package tests {

      class NavigatorSuite

    }

    package launch {

      class Booster1

    }

    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.launch.Booster2
      val booster3 = new _root_.launch.Booster3
    }

  }

  package launch {

    class Booster2

  }

  class Ship {
    val nav = new navigation.Navigator
  }

  package fleets {

    class Fleet {
      def addShip() = new Ship
    }

  }

}

package launch {

  class Booster3

}