for container in `docker ps --format '{{.Names}}'`; do 
if [ $container ==  "spark-master" ]; then  
    echo $container
    `docker exec $container echo "0 10 * * * sudo /usr/bin/spark-3.0.0-bin-hadoop3.2/bin/spark-submit --master spark://spark-master:7077 /opt/spark-technical-test_2.12-0.1.jar --class JobFreeToMove --driver-memory 1G --executor-memory 1G>/dev/null 2>&1" >> cron_bkp` 
fi
done