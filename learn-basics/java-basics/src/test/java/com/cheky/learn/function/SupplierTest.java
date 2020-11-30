package com.cheky.learn.function;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 使用 JDK 1.8 Supplier 类似 C# Func<T>
 * @author Cheky
 * @date 2020-11-30
 *
 * Reference：https://www.cnblogs.com/SIHAIloveYAN/p/11288064.html
 */
public class SupplierTest {

    /**
            * Supplier接口测试，supplier相当一个容器或者变量，可以存储值
     */
    @Test
    public void test_Supplier() {
        //① 使用Supplier接口实现方法,只有一个get方法，无参数，返回一个值
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());

        System.out.println("********************");

        //② 使用lambda表达式，
        supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());
        System.out.println("********************");

        //③ 使用方法引用
        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());
    }

    /**
     * Supplier接口测试2，使用需要Supplier的接口方法
     */
    @Test
    public void test_Supplier2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        //返回一个optional对象
        Optional<Integer> first = stream.filter(i -> i > 4)
                .findFirst();

        //optional对象有需要Supplier接口的方法
        //orElse，如果first中存在数，就返回这个数，如果不存在，就放回传入的数
        System.out.println(first.orElse(1));
        System.out.println(first.orElse(7));

        System.out.println("********************");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        //orElseGet，如果first中存在数，就返回这个数，如果不存在，就返回supplier返回的值
        System.out.println(first.orElseGet(supplier));
    }

    //除了上面使用的 Supplier 接口，还可以使用下面这些 Supplier 接口。
    //IntSupplier 、DoubleSupplier 、LongSupplier 、BooleanSupplier
}
