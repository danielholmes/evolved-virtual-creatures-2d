import com.lihaoyi.workbench.Plugin._

enablePlugins(ScalaJSPlugin)

workbenchSettings

name := "Evolved Virtual Creatures 2D"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.scalactic" % "scalactic_2.11" % "3.0.0",
  "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"
)

bootSnippet := "org.danielholmes.evc2d.Main().main();"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

