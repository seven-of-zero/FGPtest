package com.soz.pojo;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String nickname;
    private String password;
    private String email;
    private String picture;
    private String token;
    private String authority = "normal";

}
