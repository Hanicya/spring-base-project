package com.cbz;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/14
 */
public class Main {
    public static void main(String[] args) {
        Integer i = DateUtil.thisDayOfMonth();
        System.out.println(i);
        // 获取当前时间的小时
        int hour = DateUtil.date().hour(false);
        System.out.println("当前小时: " + hour);
        boolean jsonArray = JSONUtil.isTypeJSONArray("[0]");
        System.out.println(jsonArray);
        System.out.println(JSONUtil.parseArray("[0]").contains(0));
        byte s = Byte.parseByte("127");
        System.out.println(s);
    }
}
