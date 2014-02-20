import com.typesafe.tools.mima.plugin.MimaKeys.previousArtifact
import com.typesafe.tools.mima.plugin.MimaPlugin.mimaDefaultSettings

mimaDefaultSettings

scalaVersion := "2.10.3"

previousArtifact := Some("mima-tester" % "mima-tester_2.10" % "1.0")

name := "Mima Tester"

version := "1.0"

libraryDependencies += "org.scala-lang" % "scalap" % "2.10.3"

scalaSource in Compile := baseDirectory.value / System.getenv.get("SOURCE_DIR")
