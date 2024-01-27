package kafka.pure.customer

import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer

import java.nio.ByteBuffer

class CustomerSerializer extends Serializer[Customer] {

  override def serialize(topic: String, data: Customer): Array[Byte] = {
    try {
      val serializedName = data.name.getBytes("UTF-8")
      val stringSize = serializedName.length

      val buffer = ByteBuffer.allocate(4 + 4 + stringSize)
      buffer.putInt(data.id)
      buffer.putInt(stringSize)
      buffer.put(serializedName)

      buffer.array()
    } catch {
      case e: Exception => throw new SerializationException("Error when serializing Customer to byte[] " + e);
    }
  }
}
