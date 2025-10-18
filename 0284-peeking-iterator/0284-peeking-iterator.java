// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> it;
    boolean hasPeeked;
    Integer num;

	public PeekingIterator(Iterator<Integer> it) {
	    // initialize any member here.
	    this.it = it;
        this.hasPeeked = false;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(it.hasNext() && !hasPeeked) num = it.next();
        else if(hasPeeked) return num;
        else return null;

        hasPeeked = true;

        return num;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasPeeked){
            hasPeeked = false;
            return num;
        }

        if(it.hasNext()) return it.next();
        else return null;
	}
	
	@Override
	public boolean hasNext() {
	    return it.hasNext() || hasPeeked;
	}
}