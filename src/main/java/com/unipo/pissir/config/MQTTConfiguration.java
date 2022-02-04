package com.unipo.pissir.config;

import com.unipo.pissir.mqtt.SubscribeCallback;
import com.unipo.pissir.repository.TemperaturaRepository;
import com.unipo.pissir.services.TemperaturaService;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQTTConfiguration {

    @Autowired
    TemperaturaService temperaturaService;
    @Autowired
    TemperaturaRepository temperaturaRepository;

//    @Autowired
//    private Environment environment;


//    @Bean
//    @Qualifier("cache")
//    public List cacheList() {
//        return new ArrayList();
//    }

//    @Bean
//    public MQTTSubscriber crateMqttCallback(@Qualifier("cache") List cache) {
//        return new MQTTSubscriber(cache);
//    }
//
//    @Bean
//    @Autowired
//    public MqttClient connect(MQTTSubscriber callback) throws MqttException, URISyntaxException {
//        MqttConnectOptions connOpt = new MqttConnectOptions();
//        String mqqt_url = environment.getProperty("CLOUDMQTT_URL");
//        URI url = new URI(mqqt_url);
//        System.out.println("Test" + mqqt_url);
//        String[] userAndPassword = url.getRawUserInfo().split(":");
//        String broker_url = new StringBuilder()
//                .append("tcp://")
//                .append(url.getHost())
//                .append(":")
//                .append(url.getPort()).toString();
//
//
//        connOpt.setCleanSession(true);
//        connOpt.setKeepAliveInterval(30);
//        connOpt.setUserName(userAndPassword[0]);
//        connOpt.setPassword(userAndPassword[1].toCharArray());
//
//        MqttClient client = new MqttClient(broker_url, MqttClient.generateClientId());
//
//        if (callback != null)
//            client.setCallback(callback);
//        client.connect(connOpt);
//
//        callback.subscribe(client, "DOMAIN");
//
//        return client;
//    }

    @Bean
//    @Autowired
    public MqttClient generateClient(SubscribeCallback subscribeCallback) {
        // the broker URL
        String brokerURL = "tcp://localhost:1883";

        MqttClient mqttClient = null;
        try {
            mqttClient = new MqttClient(brokerURL, MqttClient.generateClientId());

        } catch (MqttException e) {
            e.printStackTrace();
        }

        try {

            // set a callback and connect to the broker
//            mqttClient.setCallback(new SubscribeCallback(temperaturaRepository, temperaturaService));
            mqttClient.setCallback(subscribeCallback);
            mqttClient.connect();

            //Subscribe to all subtopics of home
            final String topic = "home/#";
            mqttClient.subscribe(topic);

            System.out.println("The subscriber is now listening to " + topic + "...");

        } catch (MqttException e) {
            e.printStackTrace();
        }

        return mqttClient;
    }

}
