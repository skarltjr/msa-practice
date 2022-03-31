package com.msa.infrastructure.kafka;

import com.msa.infrastructure.kafka.message.ArticleCreateMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ArticleCreateProducer {
    private static final String TOPIC = "ArticleCreate";
    private final KafkaTemplate<String, ArticleCreateMessage> kafkaTemplate;

    public void sendMessage(Long articleId, Long writerId) {
        ArticleCreateMessage message = new ArticleCreateMessage(articleId, writerId);
        kafkaTemplate.send(TOPIC, message);
    }
}
