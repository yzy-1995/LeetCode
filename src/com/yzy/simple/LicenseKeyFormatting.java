package com.yzy.simple;

/**
 * ClassName: LicenseKeyFormatting
 * Description:
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * <p>
 * 我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，
 * 两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 * <p>
 * 返回 重新格式化的许可密钥 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "5F3Z-2e-9-w", k = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * 注意，两个额外的破折号需要删掉。
 * 示例 2：
 * <p>
 * 输入：S = "2-5g-3-J", k = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *
 * @author Administrator
 * @date 2023-4-12 10:23
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String s = "5F3Z-2e9-w-asdasdasdasdwa";
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println(licenseKeyFormatting.licenseKeyFormatting(s, 4));
    }


    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '-'){
                continue;
            }
            if (count ==k){
                sb.append('-');
                count=0;
            }
            sb.append(Character.toUpperCase(s.charAt(i)));
            count++;
        }
        return sb.reverse().toString();
    }
}
