package com.yzy.simple;

/**
 * ClassName: DefanginganIPAddress
 * Description:
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 * @author Administrator
 * @date 2023-4-26 11:24
 */
public class DefanginganIPAddress {
    public static void main(String[] args) {

    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
