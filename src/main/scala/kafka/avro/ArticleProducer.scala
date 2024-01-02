package kafka.avro

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.{DefaultScalaModule, ScalaObjectMapper}
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer


object ArticleProducer extends App
with ProducerUtils[Article]
with JsonStringSerializer[Article] {

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

trait JsonStringSerializer[T] {

  implicit val keySerializer: StringSerializer = new StringSerializer()
  implicit val valueSerializer: StringSerializer = new StringSerializer()

  implicit class ValueOps(value: T) {
    def toJsonString()(implicit jsonMapper: JsonMapper): String = {
      jsonMapper.writeValueAsString(value)
    }
  }
}

trait ProducerUtils[T]  {
  def produce[K, V](
                     producer: KafkaProducer[K, V],
                     topic: String,
                     key: K,
                     value: V
                   ): Unit = {
    val record = new ProducerRecord(topic, key, value)
    producer.send(record, implicitly[Callback])
  }
}