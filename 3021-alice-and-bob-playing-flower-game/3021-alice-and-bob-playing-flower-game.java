class Solution {
    public long flowerGame(int n, int m) {
        final long ne = n / 2;
        final long no = ne + (n % 2);

        final long me = m / 2;
        final long mo = me + (m % 2);

        return (no * me) + (mo * ne);
    }
}