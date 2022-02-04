package com.unipo.pissir.Mqtt;


import com.unipo.pissir.domain.Temperatura;
import com.unipo.pissir.repository.TemperaturaRepository;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.time.LocalDate;
import java.util.Date;

/**
 * Sample subscriber callback.
 * It implements the methods of @link{MqttCallback}.
 *
 * @author <a href="mailto:luigi.derussis@uniupo.it">Luigi De Russis</a>
 * @version 1.1 (21/05/2019)
 */
public class SubscribeCallback implements MqttCallback
{
    TemperaturaRepository temperaturaRepository;

    Temperatura temperatura = new Temperatura();


    @Override
    public void connectionLost(Throwable cause) {
        // what happens when the connection is lost. We could reconnect here, for example.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // what happens when a new message arrive: in this case, we print it out.
        System.out.println("Message arrived for the topic '" + topic + "': " + message.toString());

        int temperature = temperatura.getTemperatura();
        String timer = LocalDate.now().toString();
        String uffId = (String.valueOf(temperatura.getUfficioId()));
        Temperatura temperaturaEntity =  new Temperatura(temperature,uffId,timer);



       // temperaturaRepository.save(temperaturaEntity);


        // additional action for the Last Will and Testament message
        if ("home/LWT".equals(topic)) {
            System.err.println("Publisher is gone!");
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // called when delivery for a message has been completed, and all acknowledgments have been received
        // no-op, here
    }
}
