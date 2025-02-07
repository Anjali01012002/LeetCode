class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Map<Integer, Integer> ballColorMap = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        Set<Integer> distinctColors = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                
                if (colorCount.containsKey(oldColor)) {
                    int count = colorCount.get(oldColor);
                    if (count == 1) {
                        colorCount.remove(oldColor);
                        distinctColors.remove(oldColor);
                    } else {
                        colorCount.put(oldColor, count - 1);
                    }
                }
            }

            ballColorMap.put(ball, color);

            if (colorCount.containsKey(color)) {
                colorCount.put(color, colorCount.get(color) + 1);
            } else {
                colorCount.put(color, 1);
                distinctColors.add(color); 
            }

            result[i] = distinctColors.size();
        }

        return result;
    }
}
