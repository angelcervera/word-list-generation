lazy val scalatestVersion = "3.2.10"
lazy val scalaCSVVersion = "1.3.10"
lazy val betterFilesVersion = "3.9.1"

lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.13.7",
    libraryDependencies ++= Seq(
      "com.github.tototoshi" %% "scala-csv" % scalaCSVVersion,
      "com.github.pathikrit" %% "better-files" % betterFilesVersion,
      "org.scalatest" %% "scalatest" % scalatestVersion % Test
    )
  )
