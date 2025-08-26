class Solution{
    public String simplifyPath(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length(), i = n - 1;

        while(i >= 0 && s.charAt(i) == '/'){
            i--;
        }
        s = s.substring(0, i + 1);

        String[] dirs = s.split("/");
        i = dirs.length - 1;
        int parent = 0;
        while(i >= 0){
            String d = dirs[i].trim();
            if(d.length() == 0 || d.equals(".")){
                i--;
                continue;
            }

            if(d.equals("..")){
                parent++;
                i--;
                continue;
            }

            if(parent > 0){
                i--;
                parent--;
                continue;
            }

            sb.insert(0, "/" + d);
            i--;
        }
        // System.out.println(Arrays.toString(dirs));

        if(sb.isEmpty()) sb.append("/");
        return sb.toString();
    }
}