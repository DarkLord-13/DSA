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
    int max = Integer.MAX_VALUE;
    int minEle;// = Integer.MAX_VALUE;
    Stack<Integer> s;// = new Stack<>();
    PriorityQueue<Integer> q;// = new PriorityQueue<>();
    
    GfG(){
        minEle = max;
        s = new Stack<>();
        q = new PriorityQueue<>();
	}
	
    //returns min element from stack
    int getMin(){
        if(minEle==max)
            return -1;
        return minEle;
    }
    
    //returns poped element from stack
    int pop(){
        if(s.isEmpty()) return -1;
        
        int pop = s.pop();
        q.remove(pop);
        if(pop==minEle && !q.isEmpty()) 
            minEle = q.peek();
        else if(pop==minEle)
            minEle = max;
        
        return pop;
    }

    // push element x into the stack
    void push(int x){
        s.push(x);
        q.add(x);
        minEle = Math.min(minEle, x);
    }	
}

