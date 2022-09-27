package com.example.barbershopprogramming.sms.sms_sender;

import com.example.barbershopprogramming.sms.twilio_config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsSender implements SmsSender {

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        if(isPhoneNumberValid(phoneNumber)) {
            PhoneNumber to = new PhoneNumber("+4" + phoneNumber);
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
        }else {
            throw new IllegalArgumentException(("PhoneNumber [" + phoneNumber + "] is not a valid number"));
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {

        // TODO: 26.09.2022 Implement phone number validator;

        return true;
    }
}
