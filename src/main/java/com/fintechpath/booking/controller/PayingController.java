package com.fintechpath.booking.controller;
import com.fintechpath.booking.services.Paying;
import org.example.Body;
import org.springframework.http.ResponseEntity;
import org.example.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paypal")
public class PayingController {
    private static final Logger log= LoggerFactory.getLogger(PayingController.class);

    Paying paying;
    @Autowired
    public PayingController(Paying Paying)
    {
        this.paying = Paying;
    }
    @PostMapping("/pay")
    public Response Pay(@RequestBody Body body)
    {
        log.info("Paying service is starting for " + body.getCustomerName());
        return paying.Pay(body);
    }
}
