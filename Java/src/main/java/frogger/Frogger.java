package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    //Yes there is and i changed all the extra large variables to be froggerID, utilizing the already 
    //prepared class for this exact purpose
    private final Records records;
    private final FroggerID froggerID;

    public Frogger(Road road, int position, Records records, FroggerID inputFroggerID) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = inputFroggerID;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (!isValid(nextPosition) || this.road.isOccupied(nextPosition)) {
            //replaced old isOccupied with calling straight to the road's function
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    // TODO: Do you notice any issues here?
    // public boolean isOccupied(int position) {
    //     boolean[] occupied = this.road.getOccupied();
    //     return occupied[position];
    // }
    //Removed because adding it to road would make more sense
    
    public boolean isValid(int position) {
        if (position < 0) return false;
        boolean[] occupied = this.road.getOccupied();
        return position < occupied.length;
    }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      boolean success = records.addRecord(this.froggerID);
      return success;
    }

}
