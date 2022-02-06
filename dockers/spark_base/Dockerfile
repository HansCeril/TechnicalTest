# ============================ Base Installation ===============================================
# Get OpenJDK image
# Install Scala


FROM openjdk:8-jre-slim

ARG scala_version
ARG shared_workspace=/opt/workspace

RUN mkdir -p ${shared_workspace}/data && \
    mkdir -p /usr/share/man/man1 && \
    apt-get update -y && \
    apt-get install -y curl python3 r-base && \
    ln -s /usr/bin/python3 /usr/bin/python && \
    curl https://downloads.lightbend.com/scala/2.12.12/scala-2.12.12.deb -k -o scala.deb && \
    apt install -y ./scala.deb && \
    rm -rf scala.deb /var/lib/apt/lists/*

ENV SCALA_HOME="/usr/bin/scala"
ENV PATH=${PATH}:${SCALA_HOME}/bin
ENV SHARED_WORKSPACE=${shared_workspace}

# -- Runtime

VOLUME ${shared_workspace}

# ============================ Installation Spark ===============================================
# Get OpenJDK image
# Install Scala

RUN curl https://archive.apache.org/dist/spark/spark-3.0.0/spark-3.0.0-bin-hadoop3.2.tgz -o spark.tgz && \
    tar -xf spark.tgz && \
    mv spark-3.0.0-bin-hadoop3.2 /usr/bin/ && \
    echo "alias pyspark=/usr/bin/spark-3.0.0-bin-hadoop3.2/bin/pyspark" >> ~/.bashrc && \
    echo "alias spark-shell=/usr/bin/spark-3.0.0-bin-hadoop3.2/bin/spark-shell" >> ~/.bashrc && \
    mkdir /usr/bin/spark-3.0.0-bin-hadoop3.2/logs && \
    rm spark.tgz

ENV SPARK_HOME /usr/bin/spark-3.0.0-bin-hadoop3.2
ENV SPARK_MASTER_HOST spark-master
ENV SPARK_MASTER_PORT 7077
ENV PYSPARK_PYTHON python3

# ENV SPARK_LOCAL_IP spark-master
# ENV SPARK_MASTER_PORT=7077 
# ENV SPARK_MASTER=spark://spark-master:7077
# ENV SPARK_WORKLOAD=master
# ENV SPARK_MASTER_WEBUI_PORT=8080
# ENV SPARK_MASTER_LOG=/opt/spark/logs/spark-master.out

# ENV SPARK_WORKER_CORES 1
# ENV SPARK_WORKER_MEMORY 1G
# ENV SPARK_DRIVER_MEMORY 1G
# ENV SPARK_EXECUTOR_MEMORY 1G
# ENV SPARK_WORKLOAD worker
# ENV SPARK_LOCAL_IP spark-worker-1

# -- Runtime

WORKDIR ${SPARK_HOME}
