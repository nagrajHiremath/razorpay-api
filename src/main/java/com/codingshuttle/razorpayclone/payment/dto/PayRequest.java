package com.codingshuttle.razorpayclone.payment.dto;

import com.codingshuttle.razorpayclone.common.entity.Money;
import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public record PayRequest(
        UUID paymentId,
        UUID orderId,
        Money amount,
        PaymentMethod paymentMethod,
        Map<String, Object> methodDetails
) {
}
