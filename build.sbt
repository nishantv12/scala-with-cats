name := "scala-with-cats"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.4.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.5" % "test"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.12.2"

scalacOptions ++= Seq( "-Xfatal-warnings", "-Ypartial-unification")
