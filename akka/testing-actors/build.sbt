

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "testing-actors",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.17",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test",
    libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.18" % "test"
  )
