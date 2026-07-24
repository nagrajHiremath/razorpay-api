package com.codingshuttle.razorpayclone.payment.processor.dto;

public sealed interface PaymentProcessorResponse permits
        PaymentProcessorResponse.Failure,
        PaymentProcessorResponse.Pending,
        PaymentProcessorResponse.Success {

    record Failure(String errorCode, String ErrorDescription) implements PaymentProcessorResponse{}

    record Pending(String processRef) implements PaymentProcessorResponse{}

    record Success(String processRef, String bankRef) implements PaymentProcessorResponse{}
}
