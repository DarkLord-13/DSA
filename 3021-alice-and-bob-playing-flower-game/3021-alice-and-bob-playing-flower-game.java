class Solution {
    public long flowerGame(int n, int m) {
        long no, ne, mo, me;

        ne = n / 2;
        if (n % 2 == 0) {
            no = ne;
        } else {
            no = ne + 1;
        }

        me = m / 2;
        if (m % 2 == 0) {
            mo = me;
        } else {
            mo = me + 1;
        }

        return (no * me) + (mo * ne);
    }
}