package com.free2move
import org.apache.spark._
import org.apache.spark.sql.SQLContext


object JobReader {

  case class Customer(customer_id: String, customer_unique_id: String, customer_zip_code_prefix: String, //
        customer_city: String, customer_state: String)

  def main(args: Array[String]) {

    var conf = new SparkConf().setAppName("Read CSV FIle").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._


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

    //rdd.foreach(f=>{
    //  println("Col1:"+f(0)+",Col2:"+f(1))
    //})
  }


}
