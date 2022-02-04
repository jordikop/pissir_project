package com.unipo.pissir;

import com.unipo.pissir.mqtt.MQTTSubscriber;
import com.unipo.pissir.repository.TemperaturaRepository;
import com.unipo.pissir.services.TemperaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PissirApplication
{

	public static void main(String[] args) {
		SpringApplication.run(PissirApplication.class, args);
//		MQTTSubscriber subscriber = new MQTTSubscriber();
//		subscriber.start();
	}

}
