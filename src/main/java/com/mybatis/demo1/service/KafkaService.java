package com.mybatis.demo1.service;

import com.mybatis.demo1.constant.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author yuan jie
 * @Date 2021/4/15 15:28
 */
@Slf4j
@Service
public class KafkaService {
    @Autowired
    KafkaTemplate<String,String>kafkaTemplate;

    //推送消息  根据不同的topic执行不同的操作
    public void send(String topic,String message){
        kafkaTemplate.send(topic,message);
    }

    /**
     * 监听MYBATIS_MESSAGE主题 的推送
     * record 监听到的topic 数据
     */
    @KafkaListener(topics = TopicConstant.MYBATIS_MESSAGE)
    public void getMessage(ConsumerRecord<String,String> record){
        String value = record.value();
        //将传入的String类型数据 解析为原来的类型 并使用

    }

}
