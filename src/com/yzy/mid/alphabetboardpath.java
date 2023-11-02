package com.yzy.mid;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/03 02:22
 * @Description
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 *
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 *
 *
 *
 * 我们可以按下面的指令规则行动：
 *
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * （注意，字母板上只存在有字母的位置。）
 *
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 *
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * @Version 1.0
 */
public class alphabetboardpath {
    HashMap<String,String> record=new HashMap();
    int[]moveX=new int[]{-1,1,0,0};
    int[]moveY=new int[]{0,0,-1,1};
    HashMap<Integer,Character> flag=new HashMap();
    public String alphabetBoardPath(String target) {
        flag.put(-1,'!');
        flag.put(0,'U');
        flag.put(1,'D');
        flag.put(2,'L');
        flag.put(3,'R');
        char[][] map=new char[6][5];
        int cnt=0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(i==map.length-1&&j>=1){
                    map[i][j]=' ';
                } else {
                    map[i][j]=(char)((cnt++)+'a');
                }
            }
        }
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                bfs(i,j,map,new boolean[map.length][map[0].length]);
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<target.length();i++){
            String path="";
            if(i==0){
                path="a->"+String.valueOf(target.charAt(i));
            } else {
                path=String.valueOf(target.charAt(i-1))+"->"+
                        String.valueOf(target.charAt(i));
            }
            ans.append(record.get(path));
        }
        return ans.toString();
    }
    void bfs(int sX,int sY,char [][]map,boolean[][]visited){
        LinkedList<int[]> queue=new LinkedList();
        queue.add(new int[]{sX,sY,-1,0,0});
        String path=String.valueOf(map[sX][sY])+"->";
        visited[sX][sY]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[]nums=queue.removeFirst();
                int a=nums[0],b=nums[1];
                char currentChar=map[a][b];
                String currentPath=path+String.valueOf(currentChar);
                String value="";
                if(a!=sX||b!=sY){
                    String prePath =record.get(path+String.valueOf(map[nums[3]][nums[4]]));
                    value=prePath.substring(0,prePath.length()-1);
                    value=value+String.valueOf(flag.get(nums[2]))+"!";
                } else {
                    value="!";
                }
                record.put(currentPath,value);
                for(int i=0;i<4;i++){
                    int x=a+moveX[i];
                    int y=b+moveY[i];
                    if(x>=0&&y>=0&&x<map.length&&y<map[0].length&&
                            !visited[x][y]){
                        if(x==map.length-1&&y>=1){
                            continue;
                        }
                        visited[x][y]=true;
                        queue.add(new int[]{x,y,i,a,b});
                    }
                }
            }
        }
    }
}