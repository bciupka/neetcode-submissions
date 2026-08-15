class Solution {
    private Map<Integer, List<Integer>> preMap;
    private Set<Integer> visiting;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visiting = new HashSet<>();
        
        for (int[] p : prerequisites) {
            List<Integer> curr = preMap.getOrDefault(p[0],
                new ArrayList<>());
            curr.add(p[1]);

            preMap.put(p[0], curr);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }


    private boolean dfs(int i) {
        if (visiting.contains(i)) return false;
        if (preMap.getOrDefault(i, new ArrayList<>()).isEmpty())
            return true;

        visiting.add(i);
        for (int j : preMap.get(i)) {
            if (!dfs(j)) return false;
        }

        preMap.put(i, new ArrayList<>());
        visiting.remove(i);
        return true;
    }
}
