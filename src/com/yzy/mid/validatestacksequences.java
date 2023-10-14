package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/12 00:08
 * @Description
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * @Version 1.0
 */
public class validatestacksequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int top = -1;
        int pusedhIndex = 0;
        int poppedIndex = 0;
        while (pusedhIndex < pushed.length) {
            if (pushed[pusedhIndex] == popped[poppedIndex]) {
                pusedhIndex++;
                poppedIndex++;
                while (top != -1 && pushed[top] == popped[poppedIndex]) {
                    top--;
                    poppedIndex++;
                }
            } else {
                pushed[++top] = pushed[pusedhIndex++];
            }
        }
        return top == -1;
    }
}