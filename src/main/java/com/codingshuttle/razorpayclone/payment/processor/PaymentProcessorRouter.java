package com.codingshuttle.razorpayclone.payment.processor;

import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorRequest;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorResponse;

import java.util.Map;

public class PaymentProcessorRouter {

    Map<PaymentMethod, PaymentProcessor> paymentProcessors;

    public PaymentProcessorResponse charge(PaymentProcessorRequest paymentProcessorRequest) {
        PaymentProcessor processor = paymentProcessors.get(paymentProcessorRequest.paymentMethod());
        return processor.charge(paymentProcessorRequest);
    }
}
