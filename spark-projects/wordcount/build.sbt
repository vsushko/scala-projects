name := "learning-spark-mini-example"
version := "0.0.1"
scalaVersion := "2.10.4"

val sparkVersion = "1.2.0"

// additional libraries
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
)