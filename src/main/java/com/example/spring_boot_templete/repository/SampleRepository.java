package com.example.spring_boot_templete.repository;

import com.example.spring_boot_templete.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    Sample findSampleById(long id);
}
