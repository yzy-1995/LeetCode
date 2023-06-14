package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CourseSchedule
 * Description:
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * @author Administrator
 * @date 2023-6-9 16:37
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create the adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph by adding edges
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        // Keep track of visited nodes during DFS
        boolean[] visited = new boolean[numCourses];
        // Keep track of recursion stack during DFS to detect cycles
        boolean[] recursionStack = new boolean[numCourses];

        // Perform DFS on each course
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited, recursionStack)) {
                return false; // Cycle detected, not possible to finish all courses
            }
        }

        return true; // No cycle detected, it's possible to finish all courses
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, boolean[] visited, boolean[] recursionStack) {
        // If the node is already visited and not part of the recursion stack, no cycle
        if (visited[course]) {
            return false;
        }

        // Mark the node as visited and add to the recursion stack
        visited[course] = true;
        recursionStack[course] = true;

        // Check the neighbors of the node
        for (int neighbor : graph.get(course)) {
            if (!visited[neighbor] && hasCycle(neighbor, graph, visited, recursionStack)) {
                return true; // Cycle detected
            } else if (recursionStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        // Remove the node from the recursion stack
        recursionStack[course] = false;

        return false; // No cycle detected
    }
}
