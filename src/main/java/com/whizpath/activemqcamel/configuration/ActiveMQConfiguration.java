package com.whizpath.activemqcamel.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

@Configuration
public class ActiveMQConfiguration {
    
    @Bean(name = "activeMQConnectionFactory")
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory cf=new ActiveMQConnectionFactory();
        cf.setBrokerURL("tcp://localhost:61616");
        cf.setUserName("admin");
        cf.setPassword("admin");
        return cf;
    }

    @Bean(name="jmsc")
    public JmsComponent activeMQComponent(){
        JmsComponent jmsComponent = new JmsComponent();
        jmsComponent.setConnectionFactory(activeMQConnectionFactory());
        return jmsComponent;
    }

}
