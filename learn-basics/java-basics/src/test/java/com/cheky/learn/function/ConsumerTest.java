package com.cheky.learn.function;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 使用 JDK 1.8 Consumer 类似 C# Action<T>
 * @author Cheky
 * @date 2020-11-30
 *
 * Reference：https://www.cnblogs.com/SIHAIloveYAN/p/11288064.html
 */
public class ConsumerTest {

    /**
     * consumer接口测试
     */
    @Test
    public void test_Consumer() {
        //① 使用consumer接口实现方法
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer);

        System.out.println("********************");

        //② 使用lambda表达式，forEach方法需要的就是一个Consumer接口
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer<String> consumer1 = (s) -> System.out.println(s);//lambda表达式返回的就是一个Consumer接口
        stream.forEach(consumer1);
        //更直接的方式
        //stream.forEach((s) -> System.out.println(s));
        System.out.println("********************");

        //③ 使用方法引用，方法引用也是一个consumer
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer consumer2 = System.out::println;
        stream.forEach(consumer2);
        //更直接的方式
        //stream.forEach(System.out::println);
    }
}
