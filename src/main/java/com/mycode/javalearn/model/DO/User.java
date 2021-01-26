package com.mycode.javalearn.model.DO;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author toolman
 * @Date 2020/12/15 21:53
 **/
//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class User {
    private String id;

    private String name;
}
