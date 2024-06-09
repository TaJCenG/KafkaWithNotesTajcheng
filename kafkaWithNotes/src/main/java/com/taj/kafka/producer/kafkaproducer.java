package com.taj.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class kafkaproducer {
	public static void main (String [] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		
		KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(props);
		ProducerRecord<String, Integer> record = new ProducerRecord<>("OrderTopic", "TajCheng", 23);
		try {
			producer.send(record, new OrderCallback()); //AsySynchronous
			
//			RecordMetadata rmd = producer.send(record, new OrderCallback).get(); //Synchronous
//			System.out.println(rmd.partition());
//			System.out.println(rmd.partition());
//			System.out.println("TajCheng");
//			System.out.println(record);
		//producer.send(record);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			producer.close();
		}
	}

}
