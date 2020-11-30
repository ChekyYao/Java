package com.cheky.learn.basics;

import com.cheky.learn.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 使用 JDK 1.8 Optional<T>
 * @author Cheky
 * @date 2020-11-30
 *
 * Reference：https://www.cnblogs.com/zhangboyu/p/7580262.html
 * Optional 类主要解决的问题是臭名昭著的空指针异常（NullPointerException）
 */
public class OptionalTest {

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = null;
        Optional<User> opt = Optional.of(user);
        // Optional<User> opt = Optional.ofNullable(user);// 使用这个语法就不会报NPE
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        Assert.assertEquals("John", opt.get());
    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        // 写法①
        Assert.assertTrue(opt.isPresent());
        Assert.assertEquals(user.getEmail(), opt.get().getEmail());

        // 写法②
        opt.ifPresent(u -> Assert.assertEquals(user.getEmail(), u.getEmail()));
    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        Assert.assertEquals(user2.getEmail(), result.getEmail());
    }

    @Test
    public void whenValueNotNull_thenIgnoreDefault() {
        User user = new User("john@gmail.com","1234");
        User user2 = new User("anna@gmail.com", "1234");

        User result = Optional.ofNullable(user).orElse(user2);
        // User result = Optional.ofNullable(user).orElseGet( () -> user2); // 写法②

        Assert.assertEquals("john@gmail.com", result.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThrowException_thenOk() {
        User user = null;
        User result = Optional.ofNullable(user)
                .orElseThrow( () -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user)
                .map(u -> u.getEmail()).orElse("default@gmail.com");

        Assert.assertEquals(email, user.getEmail());
    }

    @Test
    public void whenFilter_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void whenEmptyOptional_thenGetValueFromOr() {
        User user = null;
        User result = Optional.ofNullable(user)
                .or( () -> Optional.of(new User("default","1234"))).get();

        Assert.assertEquals(result.getEmail(), "default");
    }

    @Test
    public void whenGetStream_thenOk() {
        User user = new User("john@gmail.com", "1234");
        List<String> emails = Optional.ofNullable(user)
                .stream()
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"))
                .map( u -> u.getEmail())
                .collect(Collectors.toList());

        Assert.assertTrue(emails.size() == 1);
        Assert.assertEquals(emails.get(0), user.getEmail());
    }

    @Test
    public void whenEmptyStream_thenReturnDefaultOptional() {
        List<User> users = new ArrayList<>();
        User user = users.stream().findFirst().orElse(new User("default", "1234"));

        Assert.assertEquals(user.getEmail(), "default");
    }
}
