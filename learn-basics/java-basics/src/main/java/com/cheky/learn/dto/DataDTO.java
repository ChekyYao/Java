package com.cheky.learn.dto;

import com.cheky.learn.model.DataDO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class DataDTO
{
    private String name;

    public DataDO convertToDTO(){
        var data = this;
        return new DataDO(data.getName());
    }
}

