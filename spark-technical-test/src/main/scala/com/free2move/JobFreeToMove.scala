package com.free2move
import com.free2move.models.CsvModelSchema

import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Dataset, Row, SparkSession}



object JobFreeToMove {

  private val LOG_LEVEL = "logLevel"
  private val CSV_FILE_CUSTOMER = "data/customer.csv"
  private val CSV_FILE_ITEMS = "data/items.csv"
  private val CSV_FILE_ORDERS = "data/orders.csv"
  private val CSV_FILE_PRODUCTS = "data/products.csv"
  private val SPARK_APP_NAME = "FreeToMoveTest"

  def main(args: Array[String]): Unit = {
    run()

  }


  def run(): Unit = {
    val spark = SparkSession
      .builder()
      .appName(SPARK_APP_NAME)
      .config("spark.master", "local")
      .getOrCreate()

    spark.sparkContext.setLogLevel("DEBUG")

    val schemaLoader = new CsvModelSchema()

    // RDD DF => Customers
    val customerDataSet = readCsvIntoDataframe(spark, CSV_FILE_CUSTOMER, schemaLoader.get_customerCsvSchema)
    customerDataSet.show()

    // RDD DF => orders
    val ordersDataSet = readCsvIntoDataframe(spark, CSV_FILE_ORDERS, schemaLoader.get_ordersCsvSchema)
    ordersDataSet.show()

    // RDD DF => Items
    val itemsDataSet = readCsvIntoDataframe(spark, CSV_FILE_ITEMS, schemaLoader.get_itemsCsvSchema)
    itemsDataSet.show()

    // RDD DF => Products
    val productsDataSet = readCsvIntoDataframe(spark, CSV_FILE_PRODUCTS, schemaLoader.get_productsCsvSchema)
    productsDataSet.show()


    // =========================================== Statistics =================================================
  }

  private def readCsvIntoDataframe(s: SparkSession, filename: String, schema: StructType) = {
    s.read
      .format("csv")
      .option("header", "true")
      .schema(schema)
      .load(filename)
  }
}
