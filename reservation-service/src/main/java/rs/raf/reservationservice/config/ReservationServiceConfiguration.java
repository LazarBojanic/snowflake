package rs.raf.reservationservice.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
@EnableJms

public class ReservationServiceConfiguration {
    @Value("${spring.activemq.broker-url}")
    public String brokerUrl;
    @Value("${destination.changePasswordNotification}")
    public String changePasswordNotification;
    @Value("${destination.registrationConfirmationNotification}")
    public String registrationConfirmationNotification;
    @Value("${destination.reservationMadeNotification}")
    public String reservationMadeNotification;
    @Value("${destination.reservationCanceledNotification}")
    public String reservationCanceledNotification;
    @Value("${destination.reservationReminderNotification}")
    public String reservationReminderNotification;
    @Bean
    public Queue changePasswordNotification() {
        return new ActiveMQQueue(changePasswordNotification);
    }
    @Bean
    public Queue registrationConfirmationNotification() {
        return new ActiveMQQueue(registrationConfirmationNotification);
    }
    @Bean
    public Queue reservationMadeNotification() {
        return new ActiveMQQueue(reservationMadeNotification);
    }
    @Bean
    public Queue reservationCanceledNotification() {
        return new ActiveMQQueue(reservationCanceledNotification);
    }
    @Bean
    public Queue reservationReminderNotification() {
        return new ActiveMQQueue(reservationReminderNotification);
    }

    @Bean
    public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(senderActiveMQConnectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(senderActiveMQConnectionFactory());
    }

}
