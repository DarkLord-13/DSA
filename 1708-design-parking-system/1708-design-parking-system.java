class ParkingSystem{
    private int[] slots;
    public ParkingSystem(int big, int medium, int small){
        this.slots = new int[4];
        this.slots[1] = big;
        this.slots[2] = medium;
        this.slots[3] = small;
    }
    
    public boolean addCar(int carType){
        if(slots[carType] > 0){
            slots[carType]--;
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */