ThisBuild / version := "0.1.0-SNAPSHOT"

//ThisBuild / scalaVersion := "3.1.0"
ThisBuild / scalaVersion := "2.13.6"

val AkkaVersion = "2.6.17"
val AkkaHttpVersion = "10.2.7"

lazy val root = (project in file("."))
  .settings(
    name := "htt3"
  )

libraryDependencies += ("com.typesafe.akka" %% "akka-http" % AkkaHttpVersion).cross(CrossVersion.for3Use2_13)
libraryDependencies += ("com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion).cross(CrossVersion.for3Use2_13)
libraryDependencies += ("com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion).cross(CrossVersion.for3Use2_13)
libraryDependencies+= ("com.typesafe.akka" %% "akka-stream" % AkkaVersion).cross(CrossVersion.for3Use2_13)