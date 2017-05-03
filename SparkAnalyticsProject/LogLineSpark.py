"""Calculates the word count of the given file.

the file can be local or if you setup cluster.

It can be hdfs file path"""

# Imports

from pyspark import SparkConf, SparkContext
from pyspark.sql import SQLContext
from operator import add,countOf
import sys
# Constants
APP_NAME = " HelloWorld of Big Data"
# OTHER FUNCTIONS/CLASSES


def parse_N_calculate_age(data):
    userid, url, location, timestamp = data.split(" ")
    return userid, url, location, long(timestamp)


userLocationMap = {}


def main(sc, filename):
    textRDD = sc.textFile(filename)
    print '######'
    print '######'
    print textRDD.count()
    # print textRDD.first()
    # print textRDD.take(5 )
    loglines = textRDD.map(lambda line: line.split(' '))

    trafficByGeography = loglines.map(lambda line: line[2]).countByValue()
    print trafficByGeography

    trafficGrouByUser = loglines.map(lambda line: line[0])
    userCounts = trafficGrouByUser.distinct().count()
    print userCounts

    trafficByUrl = loglines.map(lambda line: line[1]).countByValue()
    print trafficByUrl
    #trafficByUrl.saveToCassandra("ECommerceAnalytics","dailysummary1")


    #userByGeography = loglines.groupBy(lambda line: (line[2])).groupBy(lambda line: line[1].length)
    #print userByGeography

    #userByGeography = loglines.map(lambda line: (line[0], line[2])).reduce(lambda usr: usr)
    # print userByGeography.collect()

    # print textRDD.countApprox()
    ##words = textRDD.flatMap(lambda x: printLogLine(x))
    # for word in words:
    # print word
    ##wordcount = words.reduceByKey(add).collect()
    # for wc in wordcount:
    # print wc[0],wc[1]


if __name__ == "__main__":

    # Configure Spark
    conf = SparkConf().setAppName(APP_NAME)
    conf = conf.setMaster("local[*]")
    sc = SparkContext(conf=conf)
    filename = sys.argv[1]
    # Execute Main functionality
    main(sc, filename)
