package com.example.barbershopprogramming.sms.sms_sender;

public interface SmsSender {

    void sendSms(String phoneNumber, String message);
}
