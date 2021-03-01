package part3typesdatasets

import org.apache.spark.sql.SparkSession

/**
  *
  * @author vsushko
  */
object Datasets extends App {

  val spark = SparkSession.builder()
    .appName("DataSets")
    .config("spark.master", "local")
    .getOrCreate()


}
