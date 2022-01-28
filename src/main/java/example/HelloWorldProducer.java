package example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class HelloWorldProducer {
    public static void main(final String[] args) {
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        final String TOPIC = "hello_world";

        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            producer.send(new ProducerRecord<>(TOPIC, "Hello World!"));
            producer.send(new ProducerRecord<>(TOPIC, "I like Kafka"));
            producer.send(new ProducerRecord<>(TOPIC, "Looking forward for the Kafka training!"));
            producer.send(new ProducerRecord<>(TOPIC, "Any questions? Write me an e-mail to anatoly@zelenin.de"));
        }
        System.out.println("Successfully sent a few messages to Kafka");
    }
}
