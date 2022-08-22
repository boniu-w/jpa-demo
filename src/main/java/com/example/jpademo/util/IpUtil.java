package com.example.jpademo.util;

import java.net.InetAddress;

/************************************************************************
 * @author: wg
 * @description:
 * @createTime: 15:31 2022/8/22
 * @updateTime: 15:31 2022/8/22
 ************************************************************************/
public class IpUtil {

    public static String getInterIP1() throws Exception {
        return InetAddress.getLocalHost().getHostAddress();
    }
    // 将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
    public static long ipToLong(String strIp) {
        long[] ip = new long[4];
        // 先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    // 将十进制整数形式转换成127.0.0.1形式的ip地址
    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        // 直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    public static void primeNum(int n) {
        long start = System.currentTimeMillis();    //取开始时间
        // 质数 个数总和
        int sum = 0;
        // 1000万以内的所有质数
        // 用数组将1000万以内的数分为两大派系，质数用0代替数值，合数用1代替数值；
        // 一开始默认全部为质数，所以值全部为0，等到开始筛选的时候再把为合数的赋值为1
        int[] num = new int[n];
        num[0] = 1;          // 由于1规定不是质数，所以要提前用1标值
        // 根据埃氏筛法的结论，要得到自然数  N 以内的全部质数，必须把不大于" 二次根号  N "的所有质数的倍数剔除，剩下的就是质数
        double prescription = Math.sqrt(n);
        for (int i = 2; i <= prescription; i++) {
            // 开始把所有质数的倍数剔除，剩下的就是质数
            for (int j = i * i; j <= n; j += i) {
                // 从i*i开始去除，因为比i*i小的倍数，已经在前面去除过了
                // 例如：i=5
                // 5的2倍（10），3倍（15），在i=2的时候，已经去除过了

                num[j - 1] = 1;   // 把质数的倍数剔除，也就是赋值为1，不是质数就是合数
            }
        }
        // 遍历数组，把值为0的数全部统计出来，得到质数之和
        for (int j : num) {
            if (j == 0)
                sum++;
        }
        System.out.println(n + "以内的质数有" + sum + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
        System.out.println("");
    }


    public static void main(String[] args) {
        String ip = "10.12.12.0";
        long ipToLong = ipToLong(ip);
        System.out.println(ipToLong);
        long l = ipToLong % 32;
        System.out.println(l);

    }
}
