

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "stream-io",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.18"
  )
