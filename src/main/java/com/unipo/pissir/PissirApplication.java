package com.unipo.pissir;

import com.unipo.pissir.Mqtt.MQTTSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PissirApplication
{

	public static void main(String[] args) {
		SpringApplication.run(PissirApplication.class, args);
		MQTTSubscriber subscriber = new MQTTSubscriber();
		subscriber.start();


	}

}
