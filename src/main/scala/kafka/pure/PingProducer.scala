package kafka.pure

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object PingProducer extends App {
  private val producer = new KafkaProducer[String, String](PRODUCER_CONFIG)
  try {
    val record = new ProducerRecord[String, String](TOPIC, "ping")
    println(s"producer.send($record)")
    producer.send(record)
    println("Message sent successfully.")
  } finally {
    println("producer close")
    producer.close()
  }
}
