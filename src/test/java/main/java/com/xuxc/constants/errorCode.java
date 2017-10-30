package main.java.com.xuxc.constants;

import lombok.Data;

/**
 * Created by xuxc
 * since  2017/10/27 15:49.
 * version 1
 */

public enum errorCode {

    emailCheckError("code10000","电子邮箱格式异常","email format error"),
    inputParamIsEmpty("code10000","传入值为空","input param is empty"),;

    private String number;
    private String ch_massage;
    private String en_massage;

    private errorCode(String number,String ch_massage,String en_massage) {
        this.number = number;
        this.ch_massage = ch_massage;
        this.en_massage = en_massage;
    }

    public String getCode(){
        return number;
    }

    public String getCh_massage(String code){
        return ch_massage;
    }
}
