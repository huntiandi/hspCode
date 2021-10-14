package com.file;

import java.io.File;
import java.io.IOException;

/**
 * @ProjectName: com.file
 * @author: ZhangBiBo
 * @description: 文件创建
 * @data: 2021/10/14
 */
public class FileCreate {
    public static void main(String[] args) {
        //这里的file只是一个对象
        File file = new File("d:\\new1.txt");
        try {
            //执行create后才会真正在磁盘写入
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
