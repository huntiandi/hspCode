package com.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ProjectName: com.file
 * @author: ZhangBiBo
 * @description: 使用字符读取
 * @data: 2021/10/15
 */
public class FileReadr_ {
    public static void main(String[] args) {
        String filePath = "d:\\new1.txt";
        String filePath2 = "d:\\new2.txt";
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(filePath);
            fileWriter = new FileWriter(filePath2,true);
            int data = -1;
            char[] chars = new char[8];
            while ((data=fileReader.read(chars))!=-1){
                fileWriter.write(chars,0,data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
                //write一定要关闭或者flush，否则不会写入文件
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
