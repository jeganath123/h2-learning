package io.jegan.com.h2_database_learning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public  class Student {
        private int id;
        private String name;
        private String programCourse;
    }

