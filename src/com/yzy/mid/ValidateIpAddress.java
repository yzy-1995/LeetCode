package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/25 00:22
 * @Description
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 *
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 *
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 *
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queryIP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 示例 2：
 *
 * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * 示例 3：
 *
 * 输入：queryIP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 * @Version 1.0
 */
public class ValidateIpAddress {
    public String validIPAddress(String queryIP) {
        return isIPv4(queryIP)?"IPv4":isIPv6(queryIP)?"IPv6":"Neither";
    }
    public boolean isIPv4(String s){
        //1、根据"."分割开；2、四段；3、每段0-255；4、无前导0；5、全是digit
        String t[]=s.split("\\.",-1);
        if(t.length!=4){return false;}
        for(int i=0;i<4;i++){
            if(t[i].length()==0||t[i].length()>3||t[i].length()>1&&t[i].charAt(0)=='0'){return false;}
            int sum=0;
            for(char c:t[i].toCharArray()){
                if(!Character.isDigit(c)){return false;}
                sum=sum*10+c-'0';
            }
            if(sum>255){return false;}
        }
        return true;
    }
    public boolean isIPv6(String s){
        //1、根据":"分隔开；2、八段；3、1-4位；4、字母(abcdef)或者数字
        s=s.toLowerCase();
        String t[]=s.split(":",-1);
        if(t.length!=8){return false;}
        for(int i=0;i<8;i++){
            if(t[i].length()==0||t[i].length()>4){return false;}
            for(char c:t[i].toCharArray()){if(!(c>='0'&&c<='9')&&!(c>='a'&&c<='f')){return false;}}
        }
        return true;
    }
}