class LFUCache{
    private class Node{
        int key, val, freq;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private int minFreq = 0;
    private int cap;
    private HashMap<Integer, Node> keyToNode = new HashMap<>();
    private HashMap<Integer, LinkedHashSet<Node>> freqToNodeList = new HashMap<>();

    public LFUCache(int cap){
        this.cap = cap;
    }
    
    public int get(int key){
        if(!keyToNode.containsKey(key)){
            return -1;
        }        
        else{
            increaseFreq(keyToNode.get(key));
            return keyToNode.get(key).val;
        }
    }
    
    public void put(int key, int val){
        if(keyToNode.containsKey(key)){
            keyToNode.get(key).val = val;
            increaseFreq(keyToNode.get(key));
        }
        else{
            Node node = new Node(key, val);

            if(keyToNode.size() >= cap){
                Node del = freqToNodeList.get(minFreq).iterator().next();
                freqToNodeList.get(minFreq).remove(del);
                keyToNode.remove(del.key);
            }

            keyToNode.put(key, node);
            if(!freqToNodeList.containsKey(1)){
                freqToNodeList.put(1, new LinkedHashSet<>());
            }
            freqToNodeList.get(1).add(node);
            minFreq = 1;
        }
    }

    private void increaseFreq(Node node){
        node.freq += 1;
        freqToNodeList.get(node.freq - 1).remove(node);

        if(node.freq - 1 == minFreq && freqToNodeList.get(minFreq).size() == 0){
            minFreq++;
        }

        if(!freqToNodeList.containsKey(node.freq)){
            freqToNodeList.put(node.freq, new LinkedHashSet<>());
        }
        freqToNodeList.get(node.freq).add(node);
    }
}