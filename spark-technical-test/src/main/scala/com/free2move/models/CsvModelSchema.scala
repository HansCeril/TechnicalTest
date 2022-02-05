package com.free2move.models

import org.apache.spark.sql.types.{DataTypes, StructType}




class CsvModelSchema {


  private val customerCsvSchema = new StructType()
    .add("customer_id", DataTypes.StringType, false)
    .add("customer_unique_id", DataTypes.StringType, false)
    .add("customer_zip_code_prefix", DataTypes.IntegerType, false)
    .add("customer_city", DataTypes.StringType, false)
    .add("customer_state", DataTypes.StringType, false)



  private val ordersCsvSchema = new StructType()
    .add("order_id", DataTypes.StringType, false)
    .add("customer_id", DataTypes.StringType, false)
    .add("order_status", DataTypes.StringType, false)
    .add("order_purchase_timestamp", DataTypes.StringType, false)
    .add("order_approved_at", DataTypes.StringType, false)
    .add("order_delivered_carrier_date", DataTypes.StringType, false)
    .add("order_delivered_customer_date", DataTypes.StringType, false)
    .add("order_estimated_delivery_date", DataTypes.StringType, false)



  private val itemsCsvSchema = new StructType()
    .add("order_id", DataTypes.StringType, false)
    .add("order_item_id", DataTypes.StringType, false)
    .add("product_id", DataTypes.StringType, false)
    .add("seller_id", DataTypes.StringType, false)
    .add("shipping_limit_date", DataTypes.StringType, false)
    .add("price", DataTypes.StringType, false)
    .add("freight_value", DataTypes.StringType, false)


  private val productsCsvSchema = new StructType()
    .add("product_id", DataTypes.StringType, false)
    .add("product_category_name", DataTypes.StringType, false)
    .add("product_name_lenght", DataTypes.IntegerType, false)
    .add("product_description_lenght", DataTypes.StringType, false)
    .add("product_photos_qty", DataTypes.StringType, false)
    .add("product_weight_g", DataTypes.StringType, false)
    .add("product_length_cm", DataTypes.StringType, false)
    .add("product_height_cm", DataTypes.StringType, false)
    .add("product_category_name_english", DataTypes.StringType, false)


  def get_customerCsvSchema: StructType = customerCsvSchema
  def get_ordersCsvSchema: StructType = ordersCsvSchema
  def get_itemsCsvSchema: StructType = itemsCsvSchema
  def get_productsCsvSchema: StructType  = productsCsvSchema
}
