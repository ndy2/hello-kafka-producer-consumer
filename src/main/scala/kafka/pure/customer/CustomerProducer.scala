package kafka.pure.customer

import com.github.javafaker.Faker
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object CustomerProducer extends App {
  private val producer = new KafkaProducer[String, Customer](PRODUCER_CONFIG)
  private val faker = new Faker()

  try {
    for (i <- 1 to 50) {
      val customer = Customer(i, faker.name().username())
      val record = new ProducerRecord[String, Customer](TOPIC, customer)

      println(s"producer.send($record)")
      producer.send(record)
    }
    println("Message sent successfully.")
  } catch {
    case e: Exception => println("Exception occurred in CustomerProducer: " + e)
  } finally {
    println("producer close")
    producer.close()
  }
}
