package com.example.demo.Util;

import com.example.demo.execptions.ParamsException;
import com.mysql.cj.exceptions.SSLParamsException;


//断言
public class AssertUtil {
    public static void isTrue(Boolean flag,String msg){
        //抛出参数异常
        if(flag){
            throw new ParamsException(msg);
        }
    }
}
