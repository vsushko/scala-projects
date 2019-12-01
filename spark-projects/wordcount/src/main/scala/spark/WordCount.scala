package spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("WordCount")

    val sc = new SparkContext(conf)
    val file = sc.textFile("hdfs://user/vsushko/1.py")

    val count = file.flatMap(line => line.split(" ")).map(word => (word, 1))
    count.collect.foreach(println)
    sc.stop()
  }
}

