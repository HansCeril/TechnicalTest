package com.free2move
import com.free2move.models.CsvModelSchema
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.functions.{avg, col, count, round, sum}



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
    //

    //==========================================
    // Best Seller
    // Which User spent the most today ?
    val BestSeller = itemsDataSet
      .groupBy("seller_id")
      .agg(round(sum("price"), 2))
      .alias("total_spent")
      .withColumnRenamed("round(sum(price), 2)", "Total Item Sale")
    BestSeller.show()



    // ====================================================================

    val itemsMostSold = itemsDataSet
      .groupBy("product_id")
      .agg(count("product_id"), round(sum("price"), 2))
      .alias("total_spent")
      .withColumnRenamed("round(sum(price), 2)", "Total_Sales_items")
      .withColumnRenamed("count(product_id)", "Number_sold_product")
      .withColumnRenamed("product_id", "n_product_id")
      .orderBy(col("round(sum(price), 2)").desc)
      .limit(15)
    itemsMostSold.show()

    val productMostSold = productsDataSet
      .join(itemsMostSold, productsDataSet.col("product_id").equalTo(itemsMostSold.col("n_product_id")))
      .select("product_id", "product_category_name", "Total_Sales_items", "Number_sold_product")

    productMostSold.show()



    // ========================================= Best Customer ==================================

    val ordersConfirm = ordersDataSet
      .filter(col("order_status") === "delivered")
      .select("order_id","customer_id")

    ordersConfirm.show()

    val bestOrderItemPrice = itemsDataSet
      .select("order_id", "price")
      .orderBy(col("price").desc)
    bestOrderItemPrice.show()


    val mergeBestPriceOrder = ordersConfirm
      .join(bestOrderItemPrice, ordersConfirm.col("order_id").equalTo(bestOrderItemPrice.col("order_id")), "inner")
    mergeBestPriceOrder.show()









  }

  private def readCsvIntoDataframe(s: SparkSession, filename: String, schema: StructType) = {
    s.read
      .format("csv")
      .option("header", "true")
      .schema(schema)
      .load(filename)
  }
}
