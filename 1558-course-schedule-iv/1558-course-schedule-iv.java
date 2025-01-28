class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Step 1: Mark direct prerequisites
        for (int[] pre : prerequisites) {
            isPrerequisite[pre[0]][pre[1]] = true;
        }

        // Step 2: Floyd-Warshall Algorithm to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Step 3: Process queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }
}