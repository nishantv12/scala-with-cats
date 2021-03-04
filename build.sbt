name := "scala-with-cats"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"

scalacOptions ++= Seq( "-Xfatal-warnings", "-Ypartial-unification")
