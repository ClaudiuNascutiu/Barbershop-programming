package com.example.barbershopprogramming.sms.twilio_config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioInit.class);

    private final TwilioConfiguration twilioConfiguration;


    public TwilioInit(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized...with account sid" + twilioConfiguration.getAccountSid());
    }
}
