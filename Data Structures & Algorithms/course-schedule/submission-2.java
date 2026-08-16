class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> dependents = new HashMap<>();

        for (int i = 0; i < numCourses; i ++) {
            dependents.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            dependents.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int finished = 0;
        while (!q.isEmpty()) {
            finished++;
            int curr = q.poll();
            for (int dependent : dependents.get(curr)) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    q.offer(dependent);
                }
            }
        }

        return finished == numCourses;
    }
}
