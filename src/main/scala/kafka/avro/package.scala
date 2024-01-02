package kafka

import org.apache.kafka.clients.consumer.ConsumerConfig

import java.time.LocalDate
import java.util.Properties

package object avro {

  case class Article(
      id: String,
      title: String,
      content: String,
      created: LocalDate
  )

  val TOPIC = "avro"

  val PRODUCER_CONFIG: Properties = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props
  }

  val CONSUMER_CONFIG: Properties = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "something")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    props
  }
}
