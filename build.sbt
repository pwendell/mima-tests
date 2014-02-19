import com.typesafe.tools.mima.plugin.MimaKeys.previousArtifact
import com.typesafe.tools.mima.plugin.MimaPlugin.mimaDefaultSettings

mimaDefaultSettings

previousArtifact := Some("mima-tester" % "mima-tester_2.10" % System.getenv.get("VERSION"))

name := "Mima Tester"

version := System.getenv.get("VERSION")

scalaVersion := "2.10.3"

scalaSource in Compile := baseDirectory.value / System.getenv.get("SOURCE_DIR")
