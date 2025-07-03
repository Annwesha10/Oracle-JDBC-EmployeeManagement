package com.example.entity;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Department {
    private Integer departmentId;
    private String departmentName;
    private String departmentHead;
    private String departmentDescription;
}