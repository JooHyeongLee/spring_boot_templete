package com.example.spring_boot_templete.kafka;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class SampleProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void HelloWorld(Long id) {

        HashMap<String, Object> mes = new HashMap<>();
        mes.put("taskName", "HelloWorld");
        mes.put("id", id);
        mes.put("startDt", LocalDateTime.now());

        JSONObject mesJson = new JSONObject();
        mesJson.putAll(mes);

        kafkaTemplate.send("HelloWorld", mesJson.toJSONString());
    }
}
