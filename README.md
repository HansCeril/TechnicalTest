# TechnicalTest


# RUN

## First up all the containers with docker-compsose: 
```
docker-compose up --build
```

## Then go inside the spark master container:

```
docker exec -it spark-master bash
```

## Execute The Spark Jar application With the Command Bellow:

```
cd bin && /usr/bin/spark-3.0.0-bin-hadoop3.2/bin/spark-submit --master spark://spark-master:7077 /opt/spark-technical-test_2.13-0.1.jar --class JobFreeToMove --driver-memory 1G --executor-memory 1G
```
## Cron Script to run the Spark app every 24h

- Script to run in cron :
```
for container in `docker ps --format '{{.Names}}'`; do 
if [ $container ==  "spark-master" ]; then  
    echo $container
    `docker exec $container sh -c "cd bin && /usr/bin/spark-3.0.0-bin-hadoop3.2/bin/spark-submit --master spark://spark-master:7077 /opt/spark-technical-test_2.13-0.1.jar --class JobFreeToMove --driver-memory 1G --executor-memory 1G"` 
fi
done
```
- get the path where the cronspark_submit.sh is by using pwd cmd (ex : TechnicalTest/dockers/cronspark_submit.sh)
- Create crontab
```
crontab -e
0 0 * * * /cygdrive/c/Users/QFZF0680/Desktop/TechnicalTest/dockers/cronspark_submit.sh
```

### Access to the WebUI

| Application     | URL                                      
| --------------- | ----------------------------------------
| Spark_master    | localhost:8080                           
| Spark-worker-1  | localhost:8081                        
| Spark-worker-2  | localhost:8082                      



# Statisctic

## Best Customers


  ```scala
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
      .orderBy(col("price").desc)
    mergeBestPriceOrder.show()
  ```

<p align="center"><img src="images/BestCustumer.PNG"></p>


##  Best Products


  ```scala
  val itemsMostSold = itemsDataSet
      .groupBy("product_id")
      .agg(count("product_id"), round(sum("price"), 2))
      .alias("total_spent")
      .withColumnRenamed("round(sum(price), 2)", "Total_Sales_items")
      .withColumnRenamed("count(product_id)", "Number_sold_product")
      .withColumnRenamed("product_id", "n_product_id")
      .orderBy(col("round(sum(price), 2)").desc)

    val productMostSold = productsDataSet
      .join(itemsMostSold, productsDataSet.col("product_id").equalTo(itemsMostSold.col("n_product_id")))
      .select("product_id", "product_category_name", "Total_Sales_items", "Number_sold_product")
      .orderBy(col("Total_Sales_items").desc)
      .limit(5)
    productMostSold.show()
  ```

<p align="center"><img src="images/BestProduct.PNG"></p>


## Best Sellers

```scala
val BestSeller = itemsDataSet
      .groupBy("seller_id")
      .agg(round(sum("price"), 2))
      .alias("total_spent")
      .withColumnRenamed("round(sum(price), 2)", "Total Item Sale")
      .orderBy(col("Total Item Sale").desc)
      .limit(5)
    println("Best Seller Today")
    BestSeller.show()
```

<p align="center"><img src="images/bestSeller.PNG"></p>

## Best Orders
```scala
val bestOrderItemPrice = itemsDataSet
      .select("order_id", "price")
      .orderBy(col("price").desc)
    bestOrderItemPrice.show()
```
<p align="center"><img src="images/BestOrder.PNG"></p>
