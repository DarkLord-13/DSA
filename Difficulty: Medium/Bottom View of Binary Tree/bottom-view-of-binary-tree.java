/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution{
    public ArrayList<Integer> bottomView(Node root) {
        if (root == null) return new ArrayList<>();
    
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
    
        root.hd = 0;
        queue.add(root);
    
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int hd = node.hd;
    
            map.put(hd, node.data);  // overwrite ensures bottom view
    
            if (node.left != null) {
                node.left.hd = hd - 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.hd = hd + 1;
                queue.add(node.right);
            }
        }
    
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : map.values()) result.add(val);
        return result;
    }
}