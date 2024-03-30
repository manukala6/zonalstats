name := "scala-zonal-stats"
version := "0.1"
scalaVersion := "2.13.10"

val SparkVersion = "3.3.4"
val GeoTrellisVersion = "3.7.1"

dependencyOverrides += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.2.0"
dependencyOverrides +=  "org.scala-lang.modules" %% "scala-xml" % "2.1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % SparkVersion % "compile",
  "org.apache.spark" %% "spark-sql" % SparkVersion % "compile",
  "org.locationtech.geotrellis" %% "geotrellis-spark" % GeoTrellisVersion % "compile",
  "org.locationtech.geotrellis" %% "geotrellis-vector" % GeoTrellisVersion % "compile",
  "org.locationtech.geotrellis" %% "geotrellis-s3" % GeoTrellisVersion % "compile"
)

javaOptions in run += "-Xmx4G"