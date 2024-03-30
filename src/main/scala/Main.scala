import geotrellis.layer._
import geotrellis.spark._
import geotrellis.raster._
import geotrellis.raster.geotiff.GeoTiffRasterSource
import geotrellis.raster.mapalgebra.local._

object Main {
    def main(args: Array[String]): Unit = {
        val uri = "..//..//data//esrilandcover//21L_20220101-20230101.tif"
        val rasterSource = GeoTiffRasterSource(uri)

        // Define a window to read (e.g., top-left of the raster)
        val gridBounds = GridBounds(0, 0, rasterSource.cols / 16, rasterSource.rows / 16)
        val window: Option[Raster[MultibandTile]] = rasterSource.read(gridBounds)

        window match {
            case Some(raster) =>
                val classSums = raster.tile.band(0).toArray().groupBy(identity).mapValues(_.length).toMap
                println(s"Land cover class sums: $classSums")
            case None =>
                println("Window does not intersect the raster extent.")
        }
    }
}
