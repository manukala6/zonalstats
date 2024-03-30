import org.apache.spark.sql.SparkSession
import org.apache.spark.serializer.KryoSerializer
//import org.apache.sedona.core.serde.SedonaKryoRegistrator
//import org.apache.sedona.sql.utils.SedonaSQLRegistrator


object Spark {
  lazy val spark: SparkSession = 
    SparkSession.builder()
      .appName("zonalstats")
      .master("local[*]")
      .config("spark.serializer", classOf[KryoSerializer].getName)
//      .config("spark.kryo.registrator", classOf[SedonaKryoRegistrator].getName)
      .getOrCreate()
  
//  SedonaSQLRegistrator.registerAll(spark)
}