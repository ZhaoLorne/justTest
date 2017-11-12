package com.atguigu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer1 {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		
		//配置kafka服务地址
		props.put("bootstrap.servers", "cdh121:9092");
		//制定消费组
		props.put("group.id", "lorne");
		//是否自动确认offset
		props.put("enable.auto.commit", "true");
		//自动确认offset时间间隔
		props.put("auto.commit.interval.ms", "1000");
		//key的反序列化类
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		//value的反序列化类
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		
		//订阅topic，可多个
		consumer.subscribe("first","second");
//		consumer.subscribe(Arrays.asList("first","second"));
		while(true){
			//读取超时时间100ms
			Map<String, ConsumerRecords<String, String>> records = consumer.poll(100);
//			ConsumerRecords<String, String> records = consumer.poll(100);
			
			Set<Entry<String, ConsumerRecords<String, String>>> entry = records.entrySet();
		}
		
	}
}
