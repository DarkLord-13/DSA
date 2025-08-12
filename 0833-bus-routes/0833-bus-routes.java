import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        // Map stop -> list of buses (routes) passing through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for(int bus=0; bus<routes.length; bus++){
            for(int stop : routes[bus]){
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        q.add(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            busesTaken++;

            for(int i = 0; i < size; i++){
                int currStop = q.poll();

                for(int bus : stopToBuses.getOrDefault(currStop, Collections.emptyList())){
                    if(visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    for(int stop : routes[bus]) {
                        if(stop == target) return busesTaken;
                        if(!visitedStops.contains(stop)) {
                            visitedStops.add(stop);
                            q.offer(stop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
