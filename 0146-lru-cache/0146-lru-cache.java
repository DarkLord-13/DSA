class LRUCache{
    private class Node{
        Node prev, next;
        int key, val;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int cap;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head, last;

    public LRUCache(int cap){
        head = new Node(-1, -1);
        last = new Node(-1, -1);
        head.next = last;
        last.prev = head;
        this.cap = cap;
    }
    
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node node = map.get(key);
            delete(node);
            insert(node);

            return node.val;
        }
    }
    
    public void put(int key, int value){
        if(map.containsKey(key)){
            map.get(key).val = value;
            Node update = map.get(key);
            delete(update);
            insert(update);
        }
        else{
            Node newNode = new Node(key, value);
            
            if(map.size() >= cap){
                delete(last.prev);                
            }

            insert(newNode);
        }
    }

    private void insert(Node node){
        Node old = head.next;
        head.next = node;
        node.prev = head;
        node.next = old;
        old.prev = node;

        map.put(node.key, node);
    }

    private void delete(Node del){
        if(head.next == last){
            return;
        }

        Node prev = del.prev;
        Node next = del.next;
        prev.next = next;
        next.prev = prev;
        del.prev = null;
        del.next = null;

        map.remove(del.key);        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */