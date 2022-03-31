package com.msa.infrastructure.kafka;

import com.msa.infrastructure.kafka.message.ArticleCreateMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleCreateConsumer {
    @KafkaListener(topics = "ArticleCreate", groupId = "user", containerFactory = "articleCreateMessageListener")
    public void consume(ArticleCreateMessage message) {
        System.out.println(message.getArticleId() +" "+ message.getWriterId() + " 메세지가 잘 도착했네요");
    }
}
