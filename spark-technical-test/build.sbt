name := "spark-technical-test"

version := "0.1"

scalaVersion := "2.12.12"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  Seq(
    "org.apache.spark" %% "spark-core" % "3.0.0",
    "org.apache.spark" %% "spark-sql" % "3.0.0",
  )
}


val mainClassString = "JobFreeToMove"
