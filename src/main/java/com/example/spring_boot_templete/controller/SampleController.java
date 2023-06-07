package com.example.spring_boot_templete.controller;

import com.example.spring_boot_templete.common.Response;
import com.example.spring_boot_templete.common.ResultCode;
import com.example.spring_boot_templete.model.Sample;
import com.example.spring_boot_templete.service.SampleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {
    private final SampleService sampleService;
    @Value("${variable.greet}")
    private String greet;

    @Transactional
    @GetMapping("/greet")
    public Response<String> greet(
    ) {
        return new Response<>(greet, ResultCode.DATA_SUCCESS);
    }

    @Transactional
    @GetMapping("/{id}")
    public Response<String> getSample(
            @PathVariable("id") long id
    ) {
        Sample sample = sampleService.findSampleByEquals(id);
        return new Response(sample, ResultCode.DATA_SUCCESS);
    }
}
