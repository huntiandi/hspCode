package com.design.template;

/**
 * @ProjectName: com.design.template
 * @author: ZhsngBiBo
 * @description:
 * @data: 2021/9/22
 */
public class BB extends Template{
    @Override
    public void job() {
        long sum = 0;
        for (long i = 0; i < 500000; i++) {
            sum *=i;
        }
    }
}
