
name := "intellij-lift"

version := "0.1"

scalaVersion := "2.12.3"

enablePlugins(SbtIdeaPlugin)

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"

unmanagedJars in Compile := ideaMainJars.value