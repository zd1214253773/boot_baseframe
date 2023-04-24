package com.sungrow.wind.exception;

/**
 * @author ZHENGDONG
 * @date 2020/12/8 16:24
 */
public class CircularDependencyException extends RuntimeException {


    public CircularDependencyException(String mesg) {
        super(mesg);
    }
}
