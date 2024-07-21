class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        
        // Build the graph and in-degrees for row conditions
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        int[] rowInDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            rowGraph[i] = new ArrayList<>();
        }
        for (int[] condition : rowConditions) {
            int above = condition[0];
            int below = condition[1];
            rowGraph[above].add(below);
            rowInDegree[below]++;
        }
        
        // Topological sort for row
        List<Integer> rowOrder = topologicalSort(rowGraph, rowInDegree, k);
        if (rowOrder.size() < k) return new int[0][0]; // cycle detected
        
        // Build the graph and in-degrees for column conditions
        List<Integer>[] colGraph = new ArrayList[k + 1];
        int[] colInDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            colGraph[i] = new ArrayList<>();
        }
        for (int[] condition : colConditions) {
            int left = condition[0];
            int right = condition[1];
            colGraph[left].add(right);
            colInDegree[right]++;
        }
        
        // Topological sort for column
        List<Integer> colOrder = topologicalSort(colGraph, colInDegree, k);
        if (colOrder.size() < k) return new int[0][0]; // cycle detected
        
        // Build position maps
        Map<Integer, Integer> rowPosition = new HashMap<>();
        Map<Integer, Integer> colPosition = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            rowPosition.put(rowOrder.get(i), i);
            colPosition.put(colOrder.get(i), i);
        }
        
        // Place numbers in the matrix
        for (int i = 1; i <= k; i++) {
            int r = rowPosition.get(i);
            int c = colPosition.get(i);
            matrix[r][c] = i;
        }
        
        return matrix;
    }

    private List<Integer> topologicalSort(List<Integer>[] graph, int[] inDegree, int k) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            for (int neighbor : graph[current]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return order;
    }
}
