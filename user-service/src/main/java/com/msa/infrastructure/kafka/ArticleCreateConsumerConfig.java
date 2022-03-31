package com.msa.infrastructure.kafka;

import com.msa.infrastructure.kafka.message.ArticleCreateMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ArticleCreateConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;

    @Bean
    public ConsumerFactory<String, ArticleCreateMessage> articleCreateMessageConsumer() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "user");

        return new DefaultKafkaConsumerFactory<>(
                configs,
                new StringDeserializer(),
                new JsonDeserializer<>(ArticleCreateMessage.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ArticleCreateMessage> articleCreateMessageListener() {
        ConcurrentKafkaListenerContainerFactory<String, ArticleCreateMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(articleCreateMessageConsumer());
        return factory;
    }
}