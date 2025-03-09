package com.hspedu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:Black Sunshine
 * Date:2025/3/8 14:44
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member implements Serializable {
    private Long id;
    private String name;
    private String pwd;
    private String mobile;
    private String email;
    private Integer gender;
}
