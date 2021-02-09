package part2dataframes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
  *
  * @author vsushko
  */
object Aggregations extends App {

  val spark = SparkSession.builder()
    .appName("Aggregations and Grouping")
    .config("spark.master", "local")
    .getOrCreate()

  val moviesDF = spark.read
    .option("inferSchema", "true")
    .json("src/main/resources/data/movies.json")

  // counting
  val genresCountDF = moviesDF.select(count(col("Major_Genre"))) // all the values except null
  genresCountDF.show()
  moviesDF.selectExpr("count(Major_Genre)")

  moviesDF.select(count("*")).show() // count all the rows, and will INCLUDE nulls

  // counting all
  moviesDF.select(countDistinct("Major_Genre")).show

  // approximate count
  moviesDF.select(approx_count_distinct("Major_Genre")).show()

  // min and max
  val minRatingDF = moviesDF.select(min(col("IMDB_Rating")))
  moviesDF.selectExpr("min(IMDB_Rating)")

  // sum
  moviesDF.select(sum(col("US_Gross")))
  moviesDF.selectExpr("sum(US_Gross)")

  // avg
  moviesDF.select(avg("Rotten_Tomatoes_Rating"))



}
