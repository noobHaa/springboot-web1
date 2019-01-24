package com.springboot.exception;

/**
 * @ProjectName: springboot-web1
 * @Package: com.springboot.exception
 * @ClassName: UserNotExitException
 * @Author: gnnt
 * @Date: 2019/1/24 16:26
 * @Version: 1.0
 */
public class UserNotExitException extends RuntimeException {
    public UserNotExitException() {
        super("用户不存在");
    }
}
