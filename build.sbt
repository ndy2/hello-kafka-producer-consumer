ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "hello-kafka-producer-consumer"
  )
libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "3.6.1",
  "io.github.embeddedkafka" %% "embedded-kafka" % "3.4.0",
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "org.assertj" % "assertj-core" % "3.24.2" % Test
)
