package com.cls.domain.ports.commons.utilities;

import com.cls.model.dto.commons.LogsRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Utilities {
    public Date getDate() {
        return new Date();
    }

    public String convertJsonToStringLogsRequest(LogsRequest logsRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(logsRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public LogsRequest convertStringToJsonLogsRequest(String logsRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(logsRequest, LogsRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
