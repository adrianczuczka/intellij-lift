lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.11.8"
)

val parsers = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"
val lift = "lift" %% "lift" % "1.0"

lazy val intellijLift = (project in file(".")).
  enablePlugins(SbtIdeaPlugin).
  settings(commonSettings: _*).
  settings(
    name := "intellij-lift",
    javacOptions in Global ++= Seq("-source", "1.8", "-target", "1.8"),
    scalacOptions in Global ++= Seq("-target:jvm-1.8", "-deprecation"),
    libraryDependencies += parsers,
    libraryDependencies += lift,
    unmanagedSourceDirectories in Compile += baseDirectory.value / "gen" ,
    unmanagedJars in Compile := Seq.empty[sbt.Attributed[java.io.File]]
)