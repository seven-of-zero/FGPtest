package com.soz.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Comment {

    private String username;
    private String comment;
    private Integer article;

}
