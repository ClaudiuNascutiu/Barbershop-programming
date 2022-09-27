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
    private final String authToken = "35086e9498894798730456a8acf9e20e";
    private final String trialNumber = "+18434387133";
}
