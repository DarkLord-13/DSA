class Solution{
    List<List<Integer>> ll = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root){
        f(root, new ArrayList<>());

        List<String> ret = new ArrayList<>();
        for(List<Integer> l: ll){
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<l.size(); i++){
                sb.append(l.get(i));
                if(i < l.size()-1){
                    sb.append("->");
                }
            }

            ret.add(sb.toString());
        }
        
        return ret;
    }
    void f(TreeNode root, List<Integer> l){
        if(isLeaf(root)){
            l.add(root.val);            
            ll.add(new ArrayList<>(l));
            l.remove(l.size()-1);
            return;
        }
        if(root == null){
            return;
        }

        l.add(root.val);
        f(root.left, l);
        f(root.right, l);
        l.remove(l.size()-1);
    }
    boolean isLeaf(TreeNode root){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return true;
        }

        return false;
    }
}