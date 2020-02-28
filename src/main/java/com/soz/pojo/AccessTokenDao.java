package com.soz.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccessTokenDao {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}
