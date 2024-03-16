package com.fintechpath.booking.services;

import org.example.Body;
import org.example.Response;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "Payment-service")
public interface Paying
{
    @PostMapping("/paying/pay")
    public Response Pay(@RequestBody Body body);
}
