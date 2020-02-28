package com.soz.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
