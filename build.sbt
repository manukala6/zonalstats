name := "scala-zonal-stats"
version := "0.1"
scalaVersion := "2.13.13"

val SparkVersion = "3.3.4"
val GeoTrellisVersion = "3.7.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % SparkVersion % dependencyScope exclude("org.apache.hadoop", "*"),
  "org.apache.spark" %% "spark-sql" % SparkVersion % dependencyScope exclude("org.apache.hadoop", "*"),
  "org.locationtech.geotrellis" %% "geotrellis-spark" % GeoTrellisVersion % dependencyScope,
  "org.locationtech.geotrellis" %% "geotrellis-vector" % GeoTrellisVersion % dependencyScope,
  "org.locationtech.geotrellis" %% "geotrellis-s3" % GeoTrellisVersion  % dependencyScope,
)