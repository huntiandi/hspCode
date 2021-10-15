package com.file;

import java.io.*;

/**
 * @ProjectName: hspCode
 * @author: ZhangBiBo
 * @description: 包装流读取文件
 * @data: 2021/10/15 22:30
 */
public class BufferedRe_ {
    public static void main(String[] args) {
        String path = "d:\\new1.txt";
        String path2 = "d:\\new2.txt";
        //BufferedReader和BufferedWriter不要操作二进制文件，会损坏
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedWriter = new BufferedWriter(new FileWriter(path2));
            String len;
            //一次读取一行，为null时读完
            while ((len = bufferedReader.readLine()) != null) {
                bufferedWriter.write(len);
                //写一行来一个换行符
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader != null)
                bufferedReader.close();
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
