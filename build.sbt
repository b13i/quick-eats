name := """quick-eats"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "net.ruippeixotog" %% "scala-scraper" % "1.1.0"
)


fork in run := true
