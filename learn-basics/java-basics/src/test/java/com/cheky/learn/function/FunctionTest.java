package com.cheky.learn.function;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用 JDK 1.8 Consumer 类似 C# Func<T, R>
 * @author Cheky
 * @date 2020-11-30
 *
 * Reference：https://www.cnblogs.com/SIHAIloveYAN/p/11288064.html
 */
public class FunctionTest {

    /**
     * Function测试，function的作用是转换，将一个值转为另外一个值
     */
    @Test
    public void test_Function() {
        //① 使用map方法，泛型的第一个参数是转换前的类型，第二个是转化后的类型
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();//获取每个字符串的长度，并且返回
            }
        };

        Stream<String> stream = Stream.of("aaa", "bbbbb", "ccccccv");
        Stream<Integer> stream1 = stream.map(function);
        stream1.forEach(System.out::println);

        System.out.println("********************");

    }
}
