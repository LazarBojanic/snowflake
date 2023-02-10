package rs.raf.notificationservice.listener.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.CustomValidatorBean;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.validation.*;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MessageHelper {
    private static final Validator validator;

    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public <T> T getMessage(Message message, Class<T> classType) throws RuntimeException, JMSException {
        try {
            String json = ((TextMessage) message).getText();
            T data = objectMapper.readValue(json, classType);

            Set<ConstraintViolation<T>> violations = validator.validate(data);
            if (violations.isEmpty()) {
                return data;
            }

            printViolationsAndThrowException(violations);
            return null;
        } catch (IOException exception) {
            throw new RuntimeException("Message parsing fails.", exception);
        }
    }

    public String createTextMessage(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Problem with creating text message");
        }
    }

    private <T> void printViolationsAndThrowException(Set<ConstraintViolation<T>> violations) {
        String concatenatedViolations = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        throw new RuntimeException(concatenatedViolations);
    }
}

