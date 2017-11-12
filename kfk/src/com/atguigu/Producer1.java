package com.atguigu;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer1 {
	public static void main(String[] args) {
		
		Properties props = new Properties();
		//服务器名称及端口号
		props.put("bootstrap.servers", "cdh121:9092");
		//应答方式（在副本写完后）
		props.put("acks", "all");
		//请求失败尝试次数
		props.put("retries", "0");
		//批量数据处理大小设置
		props.put("batch.size", 16384);
		//延时时间
		props.put("linger.ms", 1);
		//缓存大小
		props.put("buffer.memory", "33554432");
		//key序列化
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		//value序列化
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String,String> producer = new KafkaProducer<>(props);
		
		for(int i=0; i<10; i++)
			producer.send(new ProducerRecord<String, String>("first", Integer.toString(i),"hello--"+i));
		
		producer.close();
		
	}
}
