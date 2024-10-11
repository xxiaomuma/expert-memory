package pers.xiaomuma.example.user.api.wrapper.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryAccountPO implements Serializable {

    private Integer status;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
