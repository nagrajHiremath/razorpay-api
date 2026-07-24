package com.codingshuttle.razorpayclone.payment.config;

import com.codingshuttle.razorpayclone.common.enums.PaymentMethod;
import com.codingshuttle.razorpayclone.payment.adapter.PaymentAdapter;
import com.codingshuttle.razorpayclone.payment.adapter.paymentAdaperImpl.CardAdapter;
import com.codingshuttle.razorpayclone.payment.adapter.paymentAdaperImpl.NetBankingAdapter;
import com.codingshuttle.razorpayclone.payment.adapter.paymentAdaperImpl.UpiAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentAdapterConfig {

    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapters(){
        return Map.of(
                PaymentMethod.CARD, new CardAdapter(),
                PaymentMethod.UPI, new UpiAdapter(),
                PaymentMethod.NET_BANKING, new NetBankingAdapter()
        );
    }
}
