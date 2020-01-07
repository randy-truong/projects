//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu


public interface Collision {
	
	double leftSide();
	double rightSide();
	double topSide();
	double bottomSide();
	
	boolean hasCollidedVertically(Collision c);
	boolean hasCollidedHorizontally(Collision c);
	
	
	

}
