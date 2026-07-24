package com.codingshuttle.razorpayclone.payment.processor.dto;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public record PaymentProcessorRequest(
        UUID processingId,
        UUID paymentId,
        PaymentMethod paymentMethod,
        Money amount,
        String pan,
        String expiry,
        Map<String, Object> methodDetails
) {

    public static PaymentProcessorRequest card(
            UUID processingId,
            UUID paymentId,
            PaymentMethod paymentMethod,
            Money amount,
            String pan,
            String expiry,
            Map<String, Object> methodDetails
    ){
        return new PaymentProcessorRequest(
                processingId,
                paymentId,
                paymentMethod,
                amount,
                pan,
                expiry,
                methodDetails
        );
    }
    public static PaymentProcessorRequest nonCard(
            UUID processingId,
            UUID paymentId,
            PaymentMethod paymentMethod,
            Money amount,
            Map<String, Object> methodDetails
    ){
        return new PaymentProcessorRequest(
                processingId,
                paymentId,
                paymentMethod,
                amount,
                null,
                null,
                methodDetails
        );
    }
}
