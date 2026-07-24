package com.codingshuttle.razorpayclone.payment.processor.strategy;

import com.codingshuttle.razorpayclone.payment.processor.PaymentProcessor;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorRequest;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorResponse;

public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest paymentProcessorRequest) {
        return null;
    }
}
