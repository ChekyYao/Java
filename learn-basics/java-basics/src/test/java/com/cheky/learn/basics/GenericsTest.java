package com.cheky.learn.basics;

import com.cheky.learn.generic.*;
import org.junit.jupiter.api.Test;


/**
 * 理解 并 测试 泛型
 * @author Cheky
 * @date 2020-11-29
 * Reference: https://www.zhihu.com/question/20400700
 * Reference: https://blog.csdn.net/zeng255938/article/details/82912517
 *
 */
public class GenericsTest {

    /**
     * 和 C# 的泛型一样
     */
    @Test
    public void testTForGetterAndSetter(){
        Plate<Fruit> p = new Plate<>(new Fruit());
//        p.setItem(new Food()); // Error
        p.setItem(new Apple()); // 可以
        var fruit = p.getItem();
    }

    /**
     * 频繁读取用 ? extends T
     *
     * ? extends T：上界通配符
     */
    @Test
    public void testExtendsForGetter() {
//        Plate<Fruit> p2 = new Plate<Apple>(new Apple()); // Error
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple()); // 解决了 上面的Error

        // 不能存入任何元素
//        p.setItem(new Food());// Error
//        p.setItem(new Fruit());// Error
//        p.setItem(new Apple());// Error
//        p.setItem(new RedApple());// Error

        // 可以读取元素
        var fruit = p.getItem(); // default type is Fruit
        Fruit fruit1 = p.getItem();
        Apple fruit2 = (Apple) p.getItem();
    }

    /**
     * 频繁写入用 ? super T
     * ? super T：下界通配符
     */
    @Test
    public void testSuperForSetter() {
//        Plate<Fruit> p2 = new Plate<Food>(new Food()); // Error
        Plate<? super Fruit> p = new Plate<Food>(new Food()); // 解决了 上面的Error
//        p.setItem(new Food()); // Error
        p.setItem(new Apple());

        var fruit = p.getItem(); // default type is Object
        Fruit fruit1 = (Fruit) p.getItem();
        Apple fruit2 = (Apple) p.getItem();
    }
}
