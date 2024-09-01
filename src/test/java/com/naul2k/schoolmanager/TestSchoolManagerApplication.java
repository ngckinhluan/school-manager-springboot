package com.naul2k.schoolmanager;

import org.springframework.boot.SpringApplication;

public class TestSchoolManagerApplication {

    public static void main(String[] args) {
        SpringApplication.from(SchoolManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
