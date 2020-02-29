package com.soz.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
@Getter
@Setter
public class ActPojo {
    private Integer id;
    private String title;
    private String publisher;
    private String content;
    private Date time;
}
