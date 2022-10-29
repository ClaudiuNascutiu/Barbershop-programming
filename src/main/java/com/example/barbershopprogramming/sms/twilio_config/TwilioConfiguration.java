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

    private final String accountSid = "";
    private final String authToken = "";
    private final String trialNumber = "+18434387133";
}
