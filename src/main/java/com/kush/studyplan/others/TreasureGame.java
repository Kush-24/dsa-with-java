package com.kush.studyplan.others;
public class TreasureGame {

    public static Integer minInstructionsToTreasure(int[] instructions, int money) {
        int n = instructions.length;

        // Create a 2D array to store the minimum cost to reach each room with available money
        int[][] dp = new int[n][money + 1];

        // Initialize the array with maximum values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= money; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // The player starts in room 0 with 0 cost
        dp[0][money] = 0;

        // Iterate through each room
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= money; j++) {
                if (dp[i][j] != Integer.MAX_VALUE) {
                    // Move forward without spending money
                    if (i + instructions[i] < n) {
                        dp[i + instructions[i]][j] = Math.min(dp[i + instructions[i]][j], dp[i][j] + 1);
                    }

                    // Try spending money to adjust instructions
                    for (int spend = 1; spend <= j && spend <= instructions[i]; spend++) {
                        if (i + instructions[i] - spend < n) {
                            dp[i + instructions[i] - spend][j - spend] = Math.min(
                                    dp[i + instructions[i] - spend][j - spend], dp[i][j] + 1);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to reach the treasure with available money
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= money; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return (min == Integer.MAX_VALUE) ? null : min;
    }

    public static void main(String[] args) {
        // Test cases
        int[] instructions1 = {1, 1, 1, 9};
        int money1 = 0;
        System.out.println(minInstructionsToTreasure(instructions1, money1)); // Output: 3

        int[] instructions2 = {1, 1, 2, 9};
        int money2 = 1;
        System.out.println(minInstructionsToTreasure(instructions2, money2)); // Output: 2
        
        int[] instructions3 = {2, 4, 1, 2, 10, 2, 3, 1, 9};
        System.out.println(minInstructionsToTreasure(instructions3, 0)); // Output: null
        System.out.println(minInstructionsToTreasure(instructions3, 1)); // Output: 5
        System.out.println(minInstructionsToTreasure(instructions3, 2)); // Output: 4
        System.out.println(minInstructionsToTreasure(instructions3, 3)); // Output: 4
    }
}
