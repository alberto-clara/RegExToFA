import java.util.*;

public class Node {
	int stateNumber;
  LinkedList<Transitions> transitionList = new LinkedList<Transitions>();

	Node ( int stateNumber){	//constructor for one state
		this.stateNumber = stateNumber;
  }
}