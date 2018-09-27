name := """other"""

resolvers ++= caBuild.resolvers

scalaVersion := caBuild.scalaV

libraryDependencies ++= caBuild.dependency

updateOptions := updateOptions.value.withCachedResolution(true)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:reflectiveCalls", "-language:implicitConversions")

sources in (Compile, doc) := Seq.empty

scalaSource in Compile := baseDirectory.value / "app"
scalaSource in Test := baseDirectory.value / "test"

publishArtifact in (Compile, packageDoc) := false

crossPaths := false

logLevel in assembly := Level.Error
