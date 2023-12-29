import io.github.embeddedkafka.EmbeddedKafka

object PingProducer extends App with EmbeddedKafka{
  EmbeddedKafka.start()
}