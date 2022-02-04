package com.unipo.pissir.Mqtt;

import com.unipo.pissir.domain.Temperatura;
import com.unipo.pissir.domain.Umidita;
import com.unipo.pissir.repository.TemperaturaRepository;
import org.eclipse.paho.client.mqttv3.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Sample publisher for MQTT. It uses the Eclipse Paho library and Mosquitto as a broker.
 * Mosquitto is expected to be installed and launched locally
 * (public test servers are available, however).
 *
 * It connects to the Mosquitto broker, set up a Last Will and Testament for the connection,
 * and publish a sample temperature value (i.e., a string equal to "20 C") on a specific topic.
 *
 * @author <a href="mailto:luigi.derussis@uniupo.it">Luigi De Russis</a>
 * @version 1.1 (21/05/2019)
 */
public class MQTTPublisher {


    // the (only) MQTT topic of this example
    private static final String TOPIC_TEMPERATURE = "home/temperature";
    private static final String TOPIC_UMIDITA = "home/umidite";

    // init the client
    private MqttClient client;

    /**
     * Constructor. It generates a client id and instantiate the MQTT client.
     */
    public MQTTPublisher()
    {
        // the broker URL
        String brokerURL = "tcp://localhost:1883";

        // A randomly generated client identifier based on the user's login
        // name and the system time
        String clientId = MqttClient.generateClientId();

        try {
            // create a new MQTT client
            client = new MqttClient(brokerURL, clientId);

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method to start the publisher. Currently, it sets a Last Will and Testament
     * message, open a non persistent connection, and publish a temperature value
     */
    public void start() {
        try {
            MqttConnectOptions options = new MqttConnectOptions();
            // persistent, durable connection
            options.setCleanSession(false);
            options.setWill(client.getTopic("home/LWT"), "I'm gone. Bye.".getBytes(), 0, false);

            // connect the publisher to the broker
            client.connect(options);
                Temperatura temperatura = new Temperatura();
                Umidita umidita = new Umidita();
            // publish something...
            publishTemperature(temperatura,umidita);

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * It prepares and publish the temperature value to a specific topic (/homestation/temperature).
     * @throws MqttException
     *
     */

    private void publishTemperature(Temperatura temperatura , Umidita umidita) throws MqttException
    {
        TemperaturaRepository temperaturaRepository;

        // get the topic
        MqttTopic temperatureTopic = client.getTopic(TOPIC_TEMPERATURE);
        MqttTopic umiditeTopic = client.getTopic(TOPIC_UMIDITA);

        // message content

        String temperature = (String.valueOf(temperatura.getTemperatura()));
        String timer = (String.valueOf(temperatura.getTimer()));
        String uffId = (String.valueOf(temperatura.getUfficioId()));


        String umidite = (String.valueOf(umidita.getUmidita()));


        // publish the message on the given topic
        // by default, the QoS is 1 and the message is not retained
        temperatureTopic.publish(new MqttMessage(temperature.getBytes()));
        temperatureTopic.publish(new MqttMessage(timer.getBytes()));
        temperatureTopic.publish(new MqttMessage(uffId.getBytes()));

        umiditeTopic.publish(new MqttMessage(umidite.getBytes()));


        // debug
        System.out.println("Published message on topic '"
                + temperatureTopic.getName() + "': " + temperature+" : "+timer+" :"+uffId);
        System.out.println("Published message on topic '" + umiditeTopic.getName() + "': " + umidite);
    }

    /**
     * The main
     */
    public static void main(String[] args) {
        MQTTPublisher publisher = new MQTTPublisher();
        publisher.start();
    }

}