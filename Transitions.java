public class Transitions {
	int current;
	char symbol;
	int pointsTo;
	Transitions(int fromState, char symbolT, int toState){		//constructor for every transition 
		this.current = fromState;
		this.symbol = symbolT;
		this.pointsTo = toState;
	}
}