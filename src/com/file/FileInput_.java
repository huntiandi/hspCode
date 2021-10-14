package com.file;

import com.hsp.collection.DoubleLinked;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @ProjectName: com.file
 * @author: ZhangBiBo
 * @description: file的输入输出流
 * @data: 2021/10/14
 */
public class FileInput_ {
    public static void main(String[] args) {
        FileInputStream fileInputStream =null;
        int read = 0;
        String filePath = "D:\\new1.txt";
        File file = new File(filePath);
        try {
                file.createNewFile();
             fileInputStream = new FileInputStream(filePath);
            while ((read= fileInputStream.read())!=-1){
                System.out.print((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //推荐使用，效率高
    @Test
    public void in(){
        FileInputStream fs = null;
        try {
            //读取文件
           fs = new FileInputStream("d:\\new1.txt");
           //当超过数组大小时，长度是4，当不到4时，返回的是实际的长度
           byte[] b = new byte[4];
           int temp = -1;
            while ((temp = fs.read(b))!=-1){
                System.out.print(new String(b,0,temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void in2(){
        FileInputStream fss = null;
        FileOutputStream foo = null;
        try {
            fss = new FileInputStream("d:\\new1.txt");
//            foo = new FileOutputStream("d:\\new2.txt");
            //添加true的意思就是在文本的末尾添加文本，而不是覆盖已有的文本
            //加入流并未关闭，还是原来的流，不会覆盖源文本，会拿几个写几个，以此提高效率
            foo = new FileOutputStream("d:\\new2.txt");
            byte[] bt = new byte[2];
            int temp = -1;
            while ((temp=fss.read(bt))!=-1){
                foo.write(bt,0,temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fss.close();
                foo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void out(){

        String path = "d:\\new1.txt";
        FileOutputStream fileOutputStream =null;
        try {
            String txt = "zhangyang";
            fileOutputStream = new FileOutputStream(path,true);
            //如果只是字符串全部写进去直接string.getBytes()
            fileOutputStream.write(txt.getBytes(),0,txt.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
