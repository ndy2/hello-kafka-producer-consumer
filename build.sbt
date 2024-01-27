ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "hello-kafka-producer-consumer"
  )
resolvers += "confluent" at "https://packages.confluent.io/maven/"
libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "3.6.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.16.1",
  "com.sksamuel.avro4s" %% "avro4s-core" % "4.1.1",
  "io.confluent" % "kafka-avro-serializer" % "7.5.1",
  "com.github.javafaker" % "javafaker" % "1.0.2" exclude ("org.yaml", "snakeyaml"),
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "org.assertj" % "assertj-core" % "3.24.2" % Test
)
