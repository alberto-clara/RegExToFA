import java.util.*;

public class Node {
	int stateNumber;
	Boolean isStart;
	Boolean isFinal;
	LinkedList<Transitions> transitionList;

	Node ( int stateNumber, Boolean isStart, Boolean isFinal){	//constructor for one state
		this.stateNumber = stateNumber;
		this.isStart = isStart;
		this.isFinal = isFinal;
		this.transitionList = new LinkedList<Transitions>();		// add a linked list of transitions for every state
	}
}