class Solution {
    public long flowerGame(int n, int m) {
        final long ne = n / 2;
        final long no = (n + 1) / 2;

        final long me = m / 2;
        final long mo = (m + 1) / 2;

        return (no * me) + (mo * ne);
    }
}