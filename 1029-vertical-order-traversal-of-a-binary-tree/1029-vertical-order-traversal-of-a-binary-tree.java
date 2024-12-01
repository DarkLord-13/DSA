class Solution {
    class Pair {
        TreeNode node;
        int i, j;

        public Pair(TreeNode node, int i, int j) {
            this.node = node;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> {            
            if (a.i != b.i)
                return a.i - b.i; // Sort by vertical level
            else if (a.j != b.j)
            return a.j - b.j; // Sort by horizontal distance
            else return a.node.val - b.node.val; // Sort by node value if both are equal
        });

        //Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int cn = node.val, i = p.i, j = p.j;

            if (!map.containsKey(j))
                map.put(j, new ArrayList<>());
            map.get(j).add(cn);

            if (node.left != null)
                q.add(new Pair(node.left, i + 1, j - 1));
            if (node.right != null)
                q.add(new Pair(node.right, i + 1, j + 1));
        }

        System.out.println(map);

        List<List<Integer>> ll = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ll.add(entry.getValue());
        }

        return ll;
    }
}