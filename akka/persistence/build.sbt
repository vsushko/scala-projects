import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "persistence",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.17",
    libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.5.18",
    libraryDependencies += "org.iq80.leveldb" % "leveldb" % "0.10",
    libraryDependencies += "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"

  )
