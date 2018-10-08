import java.util.*;

public class Node {
	int stateNumber;
	Boolean isStart;
	Boolean isFinal;
  LinkedList<Transitions> transitionList = new LinkedList<Transitions>();

	Node ( int stateNumber, Boolean isStart, Boolean isFinal){	//constructor for one state
		this.stateNumber = stateNumber;
		this.isStart = isStart;
		this.isFinal = isFinal;
  }
}