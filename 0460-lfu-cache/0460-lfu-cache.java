class LFUCache{
    private class Node{
        int key, value, freq;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int size = 0;
    private int minFreq = 0;

    // key -> Node
    private HashMap<Integer, Node> keyToNode = new HashMap<>();

    // freq -> set of Nodes
    private HashMap<Integer, LinkedHashSet<Node>> freqToNode = new HashMap<>();

    public LFUCache(int capacity){
        this.capacity = capacity;
    }
    
    public int get(int key){
        if(!keyToNode.containsKey(key)){
            return -1;
        }
        else{
            Node node = keyToNode.get(key);
            increaseFreq(node);
            return node.value;
        }
    }
    
    public void put(int key, int value){
        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            node.value = value;
            increaseFreq(node);
        }
        else{
            if(size == capacity){
                LinkedHashSet<Node> minFreqSet = freqToNode.get(minFreq);
                Node toEvict = minFreqSet.iterator().next();
                minFreqSet.remove(toEvict);
                keyToNode.remove(toEvict.key);
                size--;
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            if(!freqToNode.containsKey(1)){
                freqToNode.put(1, new LinkedHashSet<>());
            }
            freqToNode.get(1).add(newNode);
            minFreq = 1;

            size++;
        }
    }

    private void increaseFreq(Node node){
        LinkedHashSet<Node> set = freqToNode.get(node.freq);
        set.remove(node);

        if(node.freq == minFreq && set.isEmpty()){
            minFreq++;
        }

        node.freq++;
        if(!freqToNode.containsKey(node.freq)){
            freqToNode.put(node.freq, new LinkedHashSet<>());
        }
        freqToNode.get(node.freq).add(node);
    }
}