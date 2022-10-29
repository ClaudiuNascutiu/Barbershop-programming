package com.example.barbershopprogramming.sms.twilio_config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
@Getter
@Setter
public class TwilioConfiguration {

    private final String accountSid = "ACb61de0e8dfd08a82092cd797eae9bc40";
    private final String authToken = "0604e0399552b5c21929dce8062b074f";
    private final String trialNumber = "+18434387133";
}
