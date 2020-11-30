package com.cheky.learn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Cheky
 * @date 2020-11-30
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class User
{
    private String email;
    private String name;
}
