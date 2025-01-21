class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long topTotal = 0, bottomTotal = 0;
        for (int i = 0; i < n; i++) {
            topTotal += grid[0][i];
            bottomTotal += grid[1][i];
        }

        long topPrefix = 0, bottomPrefix = 0;
        long minSecondRobot = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long topRemaining = topTotal - topPrefix - grid[0][i];
            long bottomRemaining = bottomPrefix;
            long secondRobotPoints = Math.max(topRemaining, bottomRemaining);
            minSecondRobot = Math.min(minSecondRobot, secondRobotPoints);

            topPrefix += grid[0][i];
            bottomPrefix += grid[1][i];
        }

        return minSecondRobot;
    }
}
