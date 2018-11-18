

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "akka-cluster",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-cluster-tools" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-cluster-sharding" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-contrib" % "2.5.18",
    libraryDependencies += "org.iq80.leveldb" % "leveldb" % "0.10",
    libraryDependencies += "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8")

