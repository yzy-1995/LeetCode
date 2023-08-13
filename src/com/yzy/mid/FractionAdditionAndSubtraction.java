package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/13 00:16
 * @Description
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 *
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 *
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 *
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 * @Version 1.0
 */
public class FractionAdditionAndSubtraction {
    public String fractionAddition(String exp) {
        int a=0;int b=1;
        int c=0;int d=0;
        for(int i=0;i<exp.length();){
            //读第一个数
            int j=i;
            while (exp.charAt(j)!='/')j++;
            c=Integer.parseInt(exp.substring(i,j));
            i=++j;
            //读第二个数
            while(j<exp.length()&& Character.isDigit(exp.charAt(j)))j++;
            d=Integer.parseInt(exp.substring(i,j));
            i=+j;
            int[]r=getResult(a,b,c,d);
            a=r[0];b=r[1];
        }
        StringBuffer sb=new StringBuffer();
        sb.append(a+"");
        sb.append('/');
        sb.append(b+"");
        return sb.toString();
    }

    private int[] getResult(int a,int b,int c,int d){
        int n1=a*d+b*c;
        int n2=b*d;
        if(n1==0){
            return new int[]{0,1};
        }
        int t=Gcd(n1<0?-n1:n1,n2);
        return new int[]{n1/t,n2/t};
    }
    private int Gcd(int m,int n){
        if(m<n){
            int t=m;
            m=n;
            n=t;
        }
        int r=m%n;
        while(r!=0){
            m=n;
            n=r;
            r=m%n;
        }
        return n;
    }
}