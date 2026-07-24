package com.codingshuttle.razorpayclone.payment.dto;

public sealed interface PaymentResult permits PaymentResult.Failure, PaymentResult.Pending, PaymentResult.Success{

    record Pending(String ref) implements PaymentResult{}
    record Failure(String error, String message) implements PaymentResult{}
    record Success(String ref, String bankRef) implements PaymentResult{}

}
