package com.yzy.mid;

/**
 * Description: leetcode1376
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * 示例 1：
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * 示例 2：
 * 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * 输出：1
 * 解释：id = 2 的员工是公司的总负责人，也是其他所有员工的直属负责人，他需要 1 分钟来通知所有员工。
 * 上图显示了公司员工的树结构。
 * @author yzy15
 * @date 2023/05/01 00:09
 **/
public class TimeNeededtoInformAllEmployees {
    public static void main(String[] args) {

    }


    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //最终结果
        int res = 0;

        for(int i =0;i<manager.length;i++){
            //判断是否为结束点，剪枝
            if(informTime[i]==0){
                //临时值
                int temp = 0;
                int index=i;
                //向上遍历
                while(index!=-1){
                    temp+=informTime[index];
                    index=manager[index];
                }
                res = Math.max(res,temp);
            }
        }
        return res;
    }
}
