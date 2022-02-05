package com.free2move
import org.apache.spark._
import org.apache.spark.sql.SQLContext


object JobReader {

  case class Customer(customer_id: String, customer_unique_id: String, customer_zip_code_prefix: String, //
        customer_city: String, customer_state: String)

  case class Items(order_id: String, order_item_id: String, product_id: String, //
                   seller_id: String, shipping_limit_date: String, price: String, freight_value: String)

  case class Orders(order_id: String, customer_id: String, order_status: String, //
                    order_purchase_timestamp: String, order_approved_at: String, order_delivered_carrier_date: String, //
                    order_delivered_customer_date: String, order_estimated_delivery_date: String)

  def main(args: Array[String]) {

    var conf = new SparkConf().setAppName("Read CSV FIle").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val fileList = Array("data/customer.csv", "data/items.csv", "data/orders.csv", "data/products.csv")


    // ===================================  Rdd Customers  ==========================================
    val rddFromFileCustomers = sc.textFile("data/customer.csv")
    val empRddCustomers  = rddFromFileCustomers.map {
      line =>
        val column = line.split(",")
        Customer(
          column(0),
          column(1),
          column(2),
          column(3),
          column(4)
        )
    }
    val df_customers = empRddCustomers.toDF()
    df_customers.show()



    // ============================================ RDD Items ============================================
    val rddFromFileItems = sc.textFile("data/items.csv")
    val empRddItems  = rddFromFileItems.map {
      line =>
        val column = line.split(",")
        Items(
          column(0),
          column(1),
          column(2),
          column(3),
          column(4),
          column(5),
          column(6),
        )
    }
    val df_items = empRddItems.toDF()
    df_items.show()

    // ==============================================  RDD orders  ==============================================
    val rddFromFileOrders = sc.textFile("data/items.csv")
    val empRddOrders  = rddFromFileOrders.map {
      line =>
        val column = line.split(",")
        Orders(
          column(0),
          column(1),
          column(2),
          column(3),
          column(4),
          column(5),
          column(6),
          column(7)
        )
    }
    val df_orders = empRddOrders.toDF()
    df_orders.show()

    //rdd.foreach(f=>{
    //  println("Col1:"+f(0)+",Col2:"+f(1))
    //})
  }


}
