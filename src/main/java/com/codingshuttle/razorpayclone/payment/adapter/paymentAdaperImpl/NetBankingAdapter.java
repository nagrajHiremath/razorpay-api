package com.codingshuttle.razorpayclone.payment.adapter.paymentAdaperImpl;

import com.codingshuttle.razorpayclone.payment.adapter.PaymentAdapter;
import com.codingshuttle.razorpayclone.payment.dto.PayRequest;
import com.codingshuttle.razorpayclone.payment.dto.PaymentResult;
import com.codingshuttle.razorpayclone.payment.processor.PaymentProcessorRouter;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorRequest;
import com.codingshuttle.razorpayclone.payment.processor.dto.PaymentProcessorResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NetBankingAdapter implements PaymentAdapter {

    PaymentProcessorRouter paymentProcessorRouter;

    @Override
    public PaymentResult initiate(PayRequest payRequest) {

        PaymentProcessorRequest paymentProcessorRequest = PaymentProcessorRequest.nonCard(
                UUID.randomUUID(),
                payRequest.paymentId(),
                payRequest.paymentMethod(),
                payRequest.amount(),
                payRequest.methodDetails()
        );

        PaymentProcessorResponse paymentProcessorResponse = paymentProcessorRouter.charge(paymentProcessorRequest);

        return switch (paymentProcessorResponse){
            case PaymentProcessorResponse.Failure failure -> new PaymentResult.Failure(failure.errorCode(), failure.ErrorDescription());
            case PaymentProcessorResponse.Pending pending -> new PaymentResult.Pending(pending.processRef());
            case PaymentProcessorResponse.Success success -> new PaymentResult.Success(success.processRef(), success.bankRef());
        };
    }
}
