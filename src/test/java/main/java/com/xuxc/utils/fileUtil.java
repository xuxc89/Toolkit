package main.java.com.xuxc.utils;

import main.java.com.xuxc.constants.errorCode;
import org.apache.commons.io.FileUtils;
import org.assertj.core.util.Strings;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Created by xuxc
 * since  2017/10/27 15:12.
 * version v1
 */

public class fileUtil {

    private String imgPath = null;
    //1.windows 2.linux
    private int SystemType = 1;

    @Test
    public void test() {
        errorCode
    }

    public File paseMultipartFileToFile(MultipartFile multipartFile) throws Exception{
        if(Objects.isNull(multipartFile)) {
            throw new Exception(errorCode.inputParamIsEmpty.getCode());
        }
        //随机生成 上传文件名
        String filename = getRadomName(getsuffix(multipartFile));
        String filePath;
        if (Strings.isNullOrEmpty(imgPath)) {
            if (SystemType == 1) {
                filePath = "D:/img";
            } else {
                filePath = "/opt/uploadFile";
            }
        } else {
            filePath = imgPath;
        }

        //生成文件对象 可直接使用服务器端保存的文件对象
        //如生成文件不存在会抛出异常
        File serverFile = new File(filePath + filename);
        try{
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), serverFile);
        } catch (IOException ex) {

        }

        return serverFile;
//        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), serverFile);
    }

    /**
     * 产生随机文件名
     * @param suffix
     * @return
     */
    private String getRadomName(String suffix) {
        return new Date().getTime() + new Random().nextInt(999999) + suffix;
    }

    /**
     * 获取后缀
     *
     * @return
     */
    private String getsuffix(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename()
                .substring(multipartFile
                        .getOriginalFilename()
                        .lastIndexOf("."));
    }

}
