package main.java.com.xuxc.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xuxc
 * since  2017/10/24 11:06.
 * version v1
 */

@Slf4j
@Component
public class MD5Utils {

    public byte[] md5(String str) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes("utf-8"));
        byteToString(md5.digest());
//        return new String(md5.digest(str.getBytes("utf-8")),"utf-8");
//        return  new BigInteger(md5.digest(str.getBytes("utf-8"))).toString().toLowerCase();
        return md5.digest();
    }

    //base64
    public String tobase64(byte[] b) {
        BASE64Encoder base64en = new BASE64Encoder();
        String base64Str = base64en.encode(b);
        System.out.println("tobase64 :"+base64Str);
        return base64Str;
    }
    //base64end

    //toInteger加密
    private String toInteger(byte[] b) {
        return new BigInteger(b).toString(16).toUpperCase();
//        System.out.println("BigInteger :"+str);
    }
    //toInteger加密end


    @Test
    public void test() throws Exception{
        byte[] b = md5("aaa");
        String str = toInteger(b);

        System.out.println("BigInteger :"+str);
        str = tobase64(b);
//        System.out.println(md5("aaa"));
//        System.out.println(md5("aaa"));
    }
    //String 加密
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        String ret =sBuffer.toString().toUpperCase();
        System.out.println("byteToString :" + ret);
        return ret;
    }


    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
            }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
    //String 加密 end
}
