package com.example.spring_boot_templete.service;

import com.example.spring_boot_templete.model.Sample;
import com.example.spring_boot_templete.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    static final Logger logger = LoggerFactory.getLogger(SampleService.class);
    private final SampleRepository sampleRepository;

    public Sample findSampleByEquals(long id) {
        return sampleRepository.findSampleById(id);
    }

}
