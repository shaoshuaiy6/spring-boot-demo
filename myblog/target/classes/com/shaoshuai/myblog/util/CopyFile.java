package com.shaoshuai.myblog.util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName CopyFile
 * @Description
 * //使用final定义工具类，不用实例化
 * @Author Mr. Shao
 * @Date 2019/10/1112:40
 * @Version 1.0
 **/
public final class CopyFile {
    /**
     * 若实例化，则报错
     */
    private CopyFile() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try(InputStream in = new FileInputStream(source)) {
            try(OutputStream out = new FileOutputStream(target)){
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try(FileInputStream in = new FileInputStream(source)) {
            try(FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                //申请4096字节缓冲
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    //反转此缓冲区，设置当前位置指针为0，read读文件后文件指针在缓冲区末尾，需要使用flip重置
                    buffer.flip();
                    outChannel.write(buffer);
                    //清空缓冲区
                    buffer.clear();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //CopyFile copyfile = new CopyFile();
        long start = System.currentTimeMillis();
        CopyFile.fileCopyNIO("E:\\大数据.rar", "E:\\testtest");
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }
}
