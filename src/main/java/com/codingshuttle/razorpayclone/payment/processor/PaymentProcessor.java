package com.codingshuttle.razorpayclone.payment.processor;

import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorRequest;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorResponse;

public interface PaymentProcessor {
    PaymentProcessorResponse charge(PaymentProcessorRequest paymentProcessorRequest);
}
