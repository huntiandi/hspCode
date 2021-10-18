package com.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @ProjectName: com.file
 * @author: ZhangBiBo
 * @description: 使用InputStreamReader转换流解决中文乱码问题
 * @data: 2021/10/18
 */
public class InputStreamRea_ {
    public static void main(String[] args) throws Exception {
        String path = "d:\\new3.txt";
        //先将字节流指定编码转换成字符流，提高效率
        //这里的"utf-8"要和文件类型一样，文件是什么类型就指定什么类型
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"utf-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String str ;
        while ((str = bufferedReader.readLine())!=null){
            System.out.println(str);
        }
        bufferedReader.close();
    }

}
