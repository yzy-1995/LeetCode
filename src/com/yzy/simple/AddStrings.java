package com.yzy.simple;

/**
 * ClassName: AddStrings
 * Description:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * @author Administrator
 * @date 2023-4-11 14:37
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("-456", "77"));
    }

        public static String addStrings(String num1, String num2) {
            if (num1.startsWith("-") && num2.startsWith("-")) {
                return "-" + addPositiveStrings(num1.substring(1), num2.substring(1));
            }
            if (num1.startsWith("-")) {
                return subtractStrings(num2, num1.substring(1));
            }
            if (num2.startsWith("-")) {
                return subtractStrings(num1, num2.substring(1));
            }
            return addPositiveStrings(num1, num2);
        }

        private static String addPositiveStrings(String num1, String num2) {
            StringBuilder result = new StringBuilder();
            int carry = 0;
            int p1 = num1.length() - 1;
            int p2 = num2.length() - 1;

            while (p1 >= 0 || p2 >= 0) {
                int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
                int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
                int sum = x1 + x2 + carry;
                carry = sum / 10;
                result.append(sum % 10);
                p1--;
                p2--;
            }

            if (carry > 0) {
                result.append(carry);
            }

            return result.reverse().toString();
        }

        private static String subtractStrings(String num1, String num2) {
            if (compare(num1, num2) < 0) {
                return "-" + subtractStrings(num2, num1);
            }

            StringBuilder result = new StringBuilder();
            int borrow = 0;
            int p1 = num1.length() - 1;
            int p2 = num2.length() - 1;

            while (p1 >= 0 || p2 >= 0) {
                int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
                int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
                int diff = x1 - x2 - borrow;
                if (diff < 0) {
                    diff += 10;
                    borrow = 1;
                } else {
                    borrow = 0;
                }
                result.append(diff);
                p1--;
                p2--;
            }

            while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
                result.setLength(result.length() - 1);
            }

            return result.reverse().toString();
        }

        private static int compare(String num1, String num2) {
            if (num1.length() != num2.length()) {
                return num1.length() - num2.length();
            }
            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) != num2.charAt(i)) {
                    return num1.charAt(i) - num2.charAt(i);
                }
            }
            return 0;
        }




}







