package kafka.pure.customer

import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer

import java.nio.ByteBuffer

class CustomerDeserializer extends Deserializer[Customer] {

  override def deserialize(topic: String, data: Array[Byte]): Customer = {
    try {
      val buffer = ByteBuffer.wrap(data)

      val id = buffer.getInt()
      val nameSize = buffer.getInt()
      val nameBytes = new Array[Byte](nameSize)
      val name = new String(nameBytes, "UTF-8")

      Customer(id, name)
    } catch {
      case e: Exception => throw new SerializationException("Error when deserializing byte[] to Customer " + e)
    }
  }
}
