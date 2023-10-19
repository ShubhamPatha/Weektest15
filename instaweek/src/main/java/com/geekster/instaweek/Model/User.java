package com.geekster.instaweek.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor

    public class User {

        @Id
        @Pattern(regexp = "^.+@(?![Ii][Nn][Ss][Tt][Aa][Aa][Dd][Mm][Ii][Nn]\\.[Cc][Oo][Mm]$).+$")
        private String userEmail;
        @NotBlank
        private String userPassword;
        private String firstName;
        private String lastName;
        private Integer age;
        private String phoneNumber;




    }

