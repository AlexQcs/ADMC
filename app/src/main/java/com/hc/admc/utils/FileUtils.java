package com.hc.admc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by alex on 2017/8/10.
 */

public class FileUtils {
    //读取txt文件内容
    public static String getStringFromTxT(String path) {
        String str = "";
        File urlFile = new File(path);
        if (!urlFile.exists()) return str;
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream(urlFile), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String mimeTypeLine = null;
            while ((mimeTypeLine = br.readLine()) != null) {
                str = str + mimeTypeLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
