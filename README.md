# TechnicalTest

# RUN

## First up all the containers with docker-compsose: 

docker-compose up --build
## Then go inside the spark master container:
docker exec -it spark-master bash
## Execute The Spark Jar application With the Command Bellow:
/usr/bin/spark-3.0.0-bin-hadoop3.2/bin/spark-submit --master spark://spark-master:7077 /opt/spark-technical-test_2.12-0.1.jar --class JobFreeToMove --driver-memory 1G --executor-memory 1G
## Script cront to un the Spark app every 24h

### Access to the WebUI

| Application     | URL                                      
| --------------- | ----------------------------------------
| Spark_master    | localhost:8080                           
| Spark-worker-1  | localhost:8081                        
| Spark-worker-2  | localhost:8082                      



# Statisctic


#


+--------------------+---------------+
|           seller_id|Total Item Sale|
+--------------------+---------------+
|ff063b022a9a0aab9...|        12076.5|
|8e6cc767478edae94...|        6830.58|
|a49928bcdf77c55c6...|         8816.7|
|da7039f29f90ce5b4...|         1259.1|
|062ce95fa2ad4dfae...|         7521.0|
|2009a095de2a2a416...|         388.89|
|0ea22c1cfbdc755f8...|        10711.7|
|6eeed17989b0ae47c...|          557.0|
|e63e8bfa530fb1691...|         1311.7|
|4d600e08ecbe08258...|        4465.34|
|9803a40e82e45418a...|        4278.75|
|b3f19518fcec265b2...|         486.91|
|ec8879960bd2221d5...|         4062.4|
|0b64bcdb0784abc13...|          137.6|
|c522be04e020c1e7b...|         739.93|
|9c068d10aca38e85c...|         2658.9|
|297d5eccd19fa9a83...|         834.97|
|9b1050e85becf3ae9...|          85.14|
|a3082f442524a1be4...|          301.6|
|791cfcfe22fe4a771...|         596.26|
+--------------------+---------------+



+--------------------+-------------------+-----------------+
|        n_product_id|Number_sold_product|Total_Sales_items|
+--------------------+-------------------+-----------------+
|bb50f2e236e5eea01...|                195|          63885.0|
|6cdd53843498f9289...|                156|          54730.2|
|d6160fb7873f18409...|                 35|         48899.34|
|d1c427060a0f73f6b...|                343|         47214.51|
|99a4788cb24856965...|                488|         43025.56|
|3dd2a17168ec895c7...|                274|          41082.6|
|25c38557cf793876c...|                 38|         38907.32|
|5f504b3a1c75b73d6...|                 63|          37733.9|
|53b36df67ebb7c415...|                323|         37683.42|
|aca2eb7d00ea1a7b8...|                527|          37608.9|
|e0d64dcfaa3b6db5c...|                194|         31786.82|
|d285360f29ac7fd97...|                123|         31623.81|
|7a10781637204d8d1...|                143|          30467.5|
|f1c7f353075ce59d8...|                154|         29997.36|
|f819f0c84a64f02d3...|                 45|         29024.48|
+--------------------+-------------------+-----------------+



+--------------------+---------------------+-----------------+-------------------+
|          product_id|product_category_name|Total_Sales_items|Number_sold_product|
+--------------------+---------------------+-----------------+-------------------+
|5f504b3a1c75b73d6...|           cool_stuff|          37733.9|                 63|
|53b36df67ebb7c415...|        watches_gifts|         37683.42|                323|
|d1c427060a0f73f6b...| computers_accesso...|         47214.51|                343|
|99a4788cb24856965...|       bed_bath_table|         43025.56|                488|
|e0d64dcfaa3b6db5c...|        watches_gifts|         31786.82|                194|
|aca2eb7d00ea1a7b8...|      furniture_decor|          37608.9|                527|
|7a10781637204d8d1...|        watches_gifts|          30467.5|                143|
|bb50f2e236e5eea01...|        health_beauty|          63885.0|                195|
|6cdd53843498f9289...|        health_beauty|          54730.2|                156|
|d285360f29ac7fd97...|        watches_gifts|         31623.81|                123|
|f819f0c84a64f02d3...|        watches_gifts|         29024.48|                 45|
|25c38557cf793876c...|                 baby|         38907.32|                 38|
|3dd2a17168ec895c7...| computers_accesso...|          41082.6|                274|
|f1c7f353075ce59d8...|       bed_bath_table|         29997.36|                154|
|d6160fb7873f18409...|            computers|         48899.34|                 35|
+--------------------+---------------------+-----------------+-------------------+



+--------------------+------+
|            order_id| price|
+--------------------+------+
|867ce8a588cb1805f...|999.99|
|3b61aab5de69abc17...|999.99|
|edee5e7cf341c4b22...|999.99|
|f9a4ea353ce8eeffe...|999.99|
|b5796047f40aa1f6a...|999.99|
|b57da109cbc63cc9e...|999.99|
|6a0b591f69623b197...|999.99|
|e0aadee588e476e3a...|999.99|
|973acb049a8228a55...|999.99|
|ea5b7fbed8f0f55de...|999.99|
|eb4bfa31c0d54df31...|999.99|
|b5292e949af082478...|999.99|
|41af94fc8bd7a1531...|999.98|
|758d844e553488d2a...|999.90|
|878b914d30233eb8a...|999.90|
|138231385802e09f8...|999.90|
|abecbd6356fb44255...|999.90|
|4de4b5399589ac552...|999.90|
|2e2cbb3249517eed4...|999.90|
|c6ad9ae898bc6bc0f...|999.90|
+--------------------+------+


+--------------------+--------------------+--------------------+-------+
|            order_id|         customer_id|            order_id|  price|
+--------------------+--------------------+--------------------+-------+
|e481f51cbdc54678b...|9ef432eb625129730...|e481f51cbdc54678b...|  29.99|
|53cdb2fc8bc7dce0b...|b0830fb4747a6c6d2...|53cdb2fc8bc7dce0b...| 118.70|
|47770eb9100c2d0c4...|41ce2a54c0b03bf34...|47770eb9100c2d0c4...| 159.90|
|949d5b44dbf5de918...|f88197465ea7920ad...|949d5b44dbf5de918...|  45.00|
|ad21c59c0840e6cb8...|8ab97904e6daea886...|ad21c59c0840e6cb8...|  19.90|
|a4591c265e18cb1dc...|503740e9ca751ccdd...|a4591c265e18cb1dc...| 147.90|
|6514b8ad8028c9f2c...|9bdf08b4b3b52b552...|6514b8ad8028c9f2c...|  59.99|
|76c6e866289321a7c...|f54a9f0e6b351c431...|76c6e866289321a7c...|  19.90|
|e69bfb5eb88e0ed6a...|31ad1d1b63eb99624...|e69bfb5eb88e0ed6a...| 149.99|
|e6ce16cb79ec1d90b...|494dded5b201313c6...|e6ce16cb79ec1d90b...|  99.00|
|e6ce16cb79ec1d90b...|494dded5b201313c6...|e6ce16cb79ec1d90b...|  99.00|
|34513ce0c4fab462a...|7711cf624183d843a...|34513ce0c4fab462a...|  98.00|
|82566a660a982b15f...|d3e3b74c766bc6214...|82566a660a982b15f...|  31.90|
|5ff96c15d0b717ac6...|19402a48fe860416a...|5ff96c15d0b717ac6...|  19.90|
|432aaf21d85167c2c...|3df704f53d3f1d481...|432aaf21d85167c2c...|  38.25|
|dcb36b511fcac050b...|3b6828a50ffe54694...|dcb36b511fcac050b...| 132.40|
|403b97836b0c04a62...|738b086814c6fcc74...|403b97836b0c04a62...|1299.00|
|116f0b09343b49556...|3187789bec9909876...|116f0b09343b49556...|  27.99|
|85ce859fd6dc634de...|059f7fc5719c7da6c...|85ce859fd6dc634de...|  17.90|
|83018ec114eee8641...|7f8c8b9c2ae27bf33...|83018ec114eee8641...|  76.00|
+--------------------+--------------------+--------------------+-------+


