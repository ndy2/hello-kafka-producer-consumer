package kafka.pure.ping

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object PingConsumer extends App {
  private val consumer = new KafkaConsumer[String, String](CONSUMER_CONFIG)
  try {
    consumer.subscribe(Seq(TOPIC).asJava)
    while (true) {
      println(s"consumer.poll")
      val records = consumer.poll(java.time.Duration.ofMillis(10000))
      records.iterator().asScala.foreach { record =>
        println(s"Received message: record=$record")
      }
    }
  } catch {
    case e: Exception => println("Exception occurred in PingConsumer: " + e)
  } finally {
    println("consumer.close()")
    consumer.close()
  }
}
