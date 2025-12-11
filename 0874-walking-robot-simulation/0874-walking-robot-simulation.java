class Solution{
    public int robotSim(int[] com, int[][] obs){
        int x = 0, y = 0, max = 0;
        int dir = 0;

        Set<Long> obsSet = new HashSet<>();
        for(int[] ob: obs){
            obsSet.add(pack(ob[0], ob[1]));
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int c: com){           
            switch(c){
                case -2:
                    dir = (dir + 3) % 4;
                    break;
                case -1:
                    dir = (dir + 1) % 4;
                    break;
                default:
                    for(int i=0; i<c; i++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if(!obsSet.contains(pack(nx, ny))){
                            x = nx;
                            y = ny;

                            max = Math.max(max, (x*x + y*y));
                        }
                        else{
                            break;
                        }
                    }
            }
        }

        return max;
    }

    private long pack(int x, int y){
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }
}