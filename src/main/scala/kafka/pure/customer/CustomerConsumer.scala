package kafka.pure.customer

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object CustomerConsumer extends App {
  private val consumer = new KafkaConsumer[String, Customer](CONSUMER_CONFIG)
  try {
    consumer.subscribe(Seq(TOPIC).asJava)
    while (true) {
      println(s"consumer.poll")

      val records = consumer.poll(java.time.Duration.ofMillis(10000))
      records.iterator().asScala.foreach { record =>
        println(s"Received message: record=$record")
      }
    }
  } finally {
    println("consumer.close()")
    consumer.close()
  }
}
