package com.cheky.learn.basics;

import com.cheky.learn.dto.DataDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Java Stream 类似 C# Linq
 * Java -> 类似 C# =>
 * @author Cheky
 * @date 2020-11-28
 */
public class LinqLambdaTest {

    @Test
    public void linqLambda() {
        var datas = listDTO();
        var data2s = datas.stream().map(data -> data.convertToDTO()).collect(Collectors.toList());
        for (var data2 : data2s){
            System.out.println("data2 = " + data2);
        }
    }

    private List<DataDTO> listDTO() {
        List<DataDTO> result = new ArrayList<>();
        result.add(new DataDTO("A"));
        result.add(new DataDTO("B"));
        result.add(new DataDTO("C"));
        return result;
    }
}