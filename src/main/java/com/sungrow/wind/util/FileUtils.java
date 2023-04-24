package com.sungrow.wind.util;

import java.io.File;

/**
 * @author ZHENGDONG
 * @date 2021/3/15 12:18
 */

public class FileUtils {

    public static boolean createDirIfabsent(String path){
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
            return true;
        }

        return false;
    }
}
