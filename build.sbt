name := "intellij-lift"

version := "0.1"

scalaVersion := "2.11.8"

enablePlugins(SbtIdeaPlugin)

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"
libraryDependencies += "lift" %% "lift" % "1.0"

managedSourceDirectories in Compile += baseDirectory.value / "gen"

unmanagedJars in Compile := Seq.empty[sbt.Attributed[java.io.File]]