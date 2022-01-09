package com.dabaoqiang.jwt.common.result;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * @author xq
 */
@Data
public class CheckResult {

    private boolean success;

    private Claims claims;

    private String errCode;
}
