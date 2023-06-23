package com.example.spring_boot_templete.common;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LogHandler {
    public static void setLog(String level, String service, String error, String path, HttpServletRequest req, Map<String, Object> res) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String nowFormat = now.format(formatter);
        Map<String, Object> logD = new HashMap<>();

        if (level.equals("E")) {
            logD.put("level", "Error");
            logD.put("error", error);
        } else if (level.equals("I")) {
            logD.put("level", "INFO");
        } else if (level.equals("W")) {
            logD.put("level", "WARN");
        }

        if (service.equals("Web")) {
            logD.put("logger", "WebBackEndApi");
        } else if (service.equals("App")) {
            logD.put("logger", "AppBackEndApi");
        } else if (service.equals("Integration")) {
            logD.put("logger", "IntegrationApi");
        } else if (service.equals("Kafka")) {
            logD.put("logger", "Kafka");
        }

        logD.put("path", path);
        logD.put("timestamp", nowFormat);

        JSONObject logJson = new JSONObject();
        logJson.putAll(logD);
        System.out.println(logJson);
        if (level.equals("E")) {
            log.error(logJson.toJSONString());
        } else if (level.equals("I")) {
            log.info(logJson.toJSONString());
        } else if (level.equals("W")) {
            log.warn(logJson.toJSONString());
        }

    }
}
