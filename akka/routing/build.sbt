

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "routing",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.17"
  )
