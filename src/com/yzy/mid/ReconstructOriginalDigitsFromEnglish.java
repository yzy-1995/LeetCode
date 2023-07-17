package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/16 23:25
 * @Description
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 * @Version 1.0
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0;
        int sevenCount = 0;
        int eightCount = 0;
        int nineCount = 0;
        int hCount = 0;
        int fCount = 0;
        int sCount = 0;
        int oCount = 0;
        int iCount = 0;
        // z,w,u,x,g   只在0,2,4,6,8中出现
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'z'){
                zeroCount++;
            }else if(s.charAt(i) == 'w'){
                twoCount++;
            }else if(s.charAt(i) == 'u'){
                fourCount++;
            }else if(s.charAt(i) == 'x'){
                sixCount++;
            }else if(s.charAt(i) == 'g'){
                eightCount++;
            }else if(s.charAt(i) == 'h'){
                hCount++;
            }else if(s.charAt(i) == 'f'){
                fCount++;
            }else if(s.charAt(i) == 's'){
                sCount++;
            }else if(s.charAt(i) == 'o'){
                oCount++;
            }else if(s.charAt(i) == 'i'){
                iCount++;
            }
        }
        //h 3、8
        //f 4、5
        //s 6、7
        //o 0、1、2、4
        //i 9
        //3的个数
        threeCount = hCount - eightCount;
        //5的个数
        fiveCount = fCount - fourCount;
        //7的个数
        sevenCount = sCount - sixCount;
        //1的个数
        oneCount = oCount - zeroCount - twoCount - fourCount;
        //9的个数
        nineCount = iCount - fiveCount - sixCount - eightCount;
        for(int i = 0; i < zeroCount; i++){
            sb.append("0");
        }
        for(int i = 0; i < oneCount; i++){
            sb.append("1");
        }
        for(int i = 0; i < twoCount; i++){
            sb.append("2");
        }
        for(int i = 0; i < threeCount; i++){
            sb.append("3");
        }
        for(int i = 0; i < fourCount; i++){
            sb.append("4");
        }
        for(int i = 0; i < fiveCount; i++){
            sb.append("5");
        }
        for(int i = 0; i < sixCount; i++){
            sb.append("6");
        }
        for(int i = 0; i < sevenCount; i++){
            sb.append("7");
        }
        for(int i = 0; i < eightCount; i++){
            sb.append("8");
        }
        for(int i = 0; i < nineCount; i++){
            sb.append("9");
        }
        return sb.toString();
    }
}