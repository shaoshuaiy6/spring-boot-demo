package com.shaoshuai.myblog.util;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * @ClassName HttpUtils
 * @Description TODO 通过url取得文件返回InputStream类型数据
 * @Author Mr. Shao
 * @Date 2019/10/421:41
 * @Version 1.0
 **/
@Service("httpUtils")
public class HttpUtils {

    public InputStream returnBitMap(String path) {
        URL url = null;
        InputStream is =null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream();	//得到输入流

        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}
