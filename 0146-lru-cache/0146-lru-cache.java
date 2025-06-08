class LRUCache{
    class Node{
        int k, v;
        Node next, prev;

        public Node(int k, int v){
            this.k = k;
            this.v = v;
            next = null;
            prev = null;
        }
    }

    Node head, last;
    int cap;
    HashMap<Integer, Node> map;
    public LRUCache(int cap){
        this.cap = cap;
        head = new Node(-1, -1);
        last = new Node(-1, -1);
        head.next = last;
        last.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        return map.get(key).v;
    }
    
    public void put(int key, int val){
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }
        if(map.size() >= cap){
            Node rem = last.prev;
            remove(rem);
            map.remove(rem.k);
        }        

        Node newNode = new Node(key, val);
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;

        map.put(key, newNode);
    }
    void remove(Node rem){
        rem.prev.next = rem.next;
        rem.next.prev = rem.prev;
    }
}