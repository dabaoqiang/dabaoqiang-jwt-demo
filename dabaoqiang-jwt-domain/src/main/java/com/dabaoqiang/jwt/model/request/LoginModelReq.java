package com.dabaoqiang.jwt.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xq
 */
@Data
public class LoginModelReq implements Serializable {

    private Long id;

    private String name;


}
