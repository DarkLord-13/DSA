class Solution{
    char[] c;
    int n;
    List<Integer> l = new ArrayList<>();
    int max = Integer.MAX_VALUE/10;
    public List<Integer> splitIntoFibonacci(String num){
        c = num.toCharArray();
        n = c.length;

        f(0);

        if(l.size() > 2){
            return l;
        }
        else{
            return new ArrayList<>();
        }
    }
    boolean f(int numIndex){
        if(numIndex==n && l.size()>2){
            return true;
        }

        int currNum = 0;
        for(int i=numIndex; i<n; i++){
            // leading 0 not allowed but single 0 allowed
            if(i> numIndex && c[numIndex] == '0'){
                break;
            }
            
            if(currNum > max || (currNum == max && c[i]-'0' > 7)){
                break;
            }

            currNum = currNum*10 + (c[i]-'0');

            int size = l.size();

            if(size >= 2){
                int sum = l.get(size-1) + l.get(size-2);
                if(sum > currNum){
                    continue;
                }
                else if(sum < currNum){
                    break;
                }
            }

            l.add(currNum);
            if(f(i+1)){
                return true;
            }
            l.remove(l.size()-1);
        }

        return false;
    }
}