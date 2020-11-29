package com.cheky.learn.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cheky
 * @date 2020-11-29
 */
@Setter
@Getter
@AllArgsConstructor
public class Plate<T> {
    private T item;
}
