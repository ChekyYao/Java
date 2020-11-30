package com.cheky.learn.basics;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 使用 Collectors 工具类
 * @author Cheky
 * @date 2020-11-29,30
 *
 * Reference：https://www.jianshu.com/p/7eaa0969b424
 * Reference：https://www.cnblogs.com/woshimrf/p/java8-learn-collector.html
 */
public class CollectorsTest {

    @Test
    public void toCollectionTest(){
        var list = getListString();
        var collection = list.stream().collect(Collectors.toCollection(LinkedList::new));
        assert collection.size() == list.size();
    }

    @Test
    public void toListTest() {
        var list = getListString();
        List<String> ll = list.stream().collect(Collectors.toList());
    }

    @Test
    public void toSetTest() {
        var list = getListString();
        Set<String> ll = list.stream().collect(Collectors.toSet());
    }

    @Test
    public void joiningTest() {
        var list = getListString();
        // 无参方法
        String s = list.stream().collect(Collectors.joining());
        System.out.println(s);
        // 指定连接符
        String ss = list.stream().collect(Collectors.joining("-"));
        System.out.println(ss);
        // 指定连接符和前后缀
        String sss = list.stream().collect(Collectors.joining("-","S","E"));
        System.out.println(sss);
    }

    @Test
    public void mappingTest(){
        var list = getListString();
        List<Integer> ll = list.stream().limit(5).collect(Collectors.mapping(Integer::valueOf,Collectors.toList()));
    }

    @Test
    public void collectingAndThenTest(){
        var list = getListString();
        int length = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),e -> e.size()));
        System.out.println(length);
    }

    @Test
    public void countingTest(){
        var list = getListString();
        long size = list.stream().collect(Collectors.counting());
        System.out.println(size);
    }

    @Test
    public void maxByAndMinByTest(){
        var list = getListString();
        System.out.println(list.stream().collect(Collectors.maxBy((a,b) -> a.length()-b.length())));
        System.out.println(list.stream().collect(Collectors.minBy((a,b) -> a.length()-b.length())));
    }

    @Test
    public void summingTest(){
        var list = getListString();
        int i = list.stream().limit(3).collect(Collectors.summingInt(Integer::valueOf));
        long l = list.stream().limit(3).collect(Collectors.summingLong(Long::valueOf));
        double d = list.stream().limit(3).collect(Collectors.summingDouble(Double::valueOf));
        System.out.println(i +"\n" +l + "\n" + d);
    }

    @Test
    public void averagingTest(){
        var list = getListString();
        double i = list.stream().limit(3).collect(Collectors.averagingInt(Integer::valueOf));
        double l = list.stream().limit(3).collect(Collectors.averagingLong(Long::valueOf));
        double d = list.stream().limit(3).collect(Collectors.averagingDouble(Double::valueOf));
        System.out.println(i +"\n" +l + "\n" + d);
    }

    @Test
    public void reducingTest(){
        var list = getListString();
        System.out.println(list.stream().limit(4).map(String::length).collect(Collectors.reducing(Integer::sum)));
        System.out.println(list.stream().limit(3).map(String::length).collect(Collectors.reducing(0, Integer::sum)));
        System.out.println(list.stream().limit(4).collect(Collectors.reducing(0,String::length,Integer::sum)));
    }

    @Test
    public void groupingByTest(){
        var list = getListString();
        Map<Integer,List<String>> s = list.stream().collect(Collectors.groupingBy(String::length));
        Map<Integer,List<String>> ss = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        Map<Integer,Set<String>> sss = list.stream().collect(Collectors.groupingBy(String::length,HashMap::new,Collectors.toSet()));
        System.out.println(s.toString() + "\n" + ss.toString() + "\n" + sss.toString());
    }

    @Test
    public void partitioningByTest(){
        var list = getListString();
        Map<Boolean,List<String>> map = list.stream().collect(Collectors.partitioningBy(e -> e.length()>5));
        Map<Boolean,Set<String>> map2 = list.stream().collect(Collectors.partitioningBy(e -> e.length()>6,Collectors.toSet()));
        System.out.println(map.toString() + "\n" + map2.toString());
    }

    @Test
    public void toMapTest(){
        var list = getListString();
        Map<String,String> map = list.stream().limit(3).collect(Collectors.toMap(e -> e.substring(0,1),e -> e));
        Map<String,String> map1 = list.stream().collect(Collectors.toMap(e -> e.substring(0,1),e->e,(a,b)-> b));
        Map<String,String> map2 = list.stream().collect(Collectors.toMap(e -> e.substring(0,1),e->e,(a,b)-> b,HashMap::new));
        System.out.println(map.toString() + "\n" + map1.toString() + "\n" + map2.toString());
    }

    @Test
    public void summarizingTest(){
        var list = getListString();
        IntSummaryStatistics intSummary = list.stream().collect(Collectors.summarizingInt(String::length));
        LongSummaryStatistics longSummary = list.stream().limit(4).collect(Collectors.summarizingLong(Long::valueOf));
        DoubleSummaryStatistics doubleSummary = list.stream().limit(3).collect(Collectors.summarizingDouble(Double::valueOf));
        System.out.println(intSummary.toString() + "\n" + longSummary.toString() + "\n" + doubleSummary.toString());
    }

    private List<String> getListString() {
        var result = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
        return result;
    }
}
