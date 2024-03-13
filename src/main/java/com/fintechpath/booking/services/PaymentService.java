package com.fintechpath.booking.services;
import com.fintechpath.booking.controller.BookingController;
import org.example.Body;
import org.example.Response;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// rename to be PaymnetService.done
@Service
public class PaymentService {
    private static final Logger log= LoggerFactory.getLogger(PaymentService.class);
    private Paying paying;
    @Autowired
    public PaymentService(Paying paying)
    {
        this.paying= paying;
    }
    public Response Pay(Body body)
    {
        return paying.Pay(body);
    }
}
