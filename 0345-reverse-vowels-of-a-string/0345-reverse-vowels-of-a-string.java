class Solution{
    public String reverseVowels(String s){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); 
        vowels.add('o'); vowels.add('E'); vowels.add('O'); 
        vowels.add('u'); vowels.add('I'); vowels.add('U'); 
        vowels.add('A');

        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();

        while(l < r){
            if(vowels.contains(arr[l]) && vowels.contains(arr[r])){
                swap(l, r, arr);
                l++;
                r--;
            }
            else if(!vowels.contains(arr[l]) && !vowels.contains(arr[r])){
                l++;
                r--;
            }
            else{
                if(vowels.contains(arr[l])) r--;
                else l++;
            }
        }

        return new String(arr);
    }

    private void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}