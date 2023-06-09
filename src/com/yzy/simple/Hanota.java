package com.yzy.simple;

import java.util.List;

/**
 * Description: le
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 *
 * @author yzy15
 * @date 2023/05/20 15:41
 **/
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    // 将A上面n个盘子通过B移到C
    void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            // 此时A只有一个元素时候将A移动到C，事实上该操作是从位置0的柱子（具体不知道是A柱B柱还是C柱）上取出元素到位置2的柱子（也不能确定是A柱B柱还是C柱）
            C.add(A.remove(A.size() - 1));
            return;
        }

        move(n - 1, A, C, B);    // 将A上面n-1个通过C移到B
        // 将A最后一个移到C，（实际上的操作和上面同理）
        C.add(A.remove(A.size() - 1));         // 这一步操作后，A空了
        move(n - 1, B, A, C);     // 将B上面n-1个通过空的A移到C
    }
}
