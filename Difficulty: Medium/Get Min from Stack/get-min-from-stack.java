//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		
System.out.println("~");
}
		
	}
}



// } Driver Code Ends


class GfG{
    class Pair{
        int val, min;
        public Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    int max = Integer.MAX_VALUE;
    int minEle;
    Stack<Pair> s;
    
    GfG(){
        minEle = max;
        s = new Stack<>();
	}
	
    int getMin(){
        if(minEle==max) return -1;
        return minEle;
    }
    
    int pop(){
        if(s.isEmpty()) return -1;
        
        Pair p = s.pop();
        int val = p.val, min = p.min;
        
        if(s.isEmpty())
            minEle = max;
        else{
            Pair top = s.peek();
            minEle = top.min;
        }
        
        return val;
    }

    void push(int val){
        minEle = Math.min(minEle, val);
        s.push(new Pair(val, minEle));
    }
}






