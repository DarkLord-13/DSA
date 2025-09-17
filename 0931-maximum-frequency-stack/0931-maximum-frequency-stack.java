class FreqStack{

    private HashMap<Integer, Stack<Integer>> freqToNumList;
    private HashMap<Integer, Integer> numToFreq;
    private int maxFreq = 0;

    public FreqStack(){
        this.freqToNumList = new HashMap<>();   
        this.numToFreq = new HashMap<>(); 
    }
    
    public void push(int num){
        // st.push(num);
        numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);

        int f = numToFreq.get(num);
        if(!freqToNumList.containsKey(f)){
            freqToNumList.put(f, new Stack<>());
        }

        freqToNumList.get(f).push(num);

        maxFreq = Math.max(maxFreq, f);
    }
    
    public int pop(){
        int rem = freqToNumList.get(maxFreq).pop();
        numToFreq.put(rem, numToFreq.getOrDefault(rem, 0) - 1);

        if(freqToNumList.get(maxFreq).size() == 0){
            maxFreq--;
        }

        return rem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */