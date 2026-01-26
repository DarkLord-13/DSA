class Solution{
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;

        f(0, 0, new StringBuilder(s), res);

        return res;
    }

    private void f(int i, int dots, StringBuilder sb, List<String> res){
        if(i >= sb.length() || dots == 3){
            if(isValid(sb)){
                res.add(sb.toString());
            }

            return;
        }        

        sb.insert(i, '.');
        f(i + 1, dots + 1, sb, res);
        sb.deleteCharAt(i);

        f(i + 1, dots, sb, res);
    }

    private boolean isValid(StringBuilder sb){
        String[] arr = sb.toString().split("\\.");

        if(arr.length != 4) return false;

        for(String s: arr){
            if(s.length() == 0) return false;
            if(s.length() > 1 && s.charAt(0) == '0') return false;
            long val = Long.parseLong(s);

            if(val < 0L || val > 255L) return false;
        }

        return true;
    }
}