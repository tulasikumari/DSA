package Questionno8;

import java.util.Stack;
//8a solution
//Given 2D matrix of 1 and 0s. Using stack, find maximum area of square made by 0s
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            heights[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= n; j++) {
                int h = (j == n ? 0 : heights[i][j]);
                if (stack.isEmpty() || h >= heights[i][stack.peek()]) {
                    stack.push(j);
                } else {
                    int tp = stack.pop();
                    maxArea = Math.max(maxArea, heights[i][tp] * (stack.isEmpty() ? j : j - stack.peek()-1));
                    j--;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matric= {
                {'1', '0', '1', '0', '0'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '1', '0', '1', '1'}
        };
        int maxArea=maximalSquare(matric);
        System.out.println(maxArea);
        }
    }