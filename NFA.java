import java.util.*;

public class NFA {
	int startState;
	int finalState;
	protected LinkedList<Node> listState = new LinkedList<Node>();

	NFA(int s, int f){
		this.startState = s;
		this.finalState = f;
	}

	static public NFA alphaLetter(char letter, int state) {
		NFA alphaL;
		alphaL = new NFA(state, state+1);
		alphaL.listState.add(new Node(state,true,false));
		alphaL.listState.add(new Node(state+1,false,true));
		alphaL.listState.getFirst().transitionList.add(new Transitions(state, letter, state+1));
		return alphaL;
	}

	public void printNFA(){
		System.out.println("Start State is Q" + this.startState);
		System.out.println("Final State is Q" + this.finalState);
		morePrinting();
	}
	public void morePrinting(){
		int j = this.listState.size(), i = 0;
		while (i < j) {
			Node temp = this.listState.get(i);
			int x = temp.transitionList.size(), y = 0;
				while (y<x) {
				Transitions tp = temp.transitionList.get(y);
				System.out.println("(Q"+ tp.current + "," + tp.symbol + " ) ---> Q" + tp.pointsTo);
				y++;
				}
			i++;
		}
	}

	static public NFA append(NFA var1, NFA var2){
		var1.listState.getLast().transitionList.add(new Transitions(var1.finalState, 'E', var2.startState));
		var1.listState.getLast().isFinal = false;
		  
		NFA temp;
		temp = new NFA (var1.startState, var2.finalState);
		temp.listState.addAll(var1.listState);
		temp.listState.addAll(var2.listState);
		return temp;
	}

	public static NFA union(NFA var1, NFA var2, int state) {
		NFA temp;
		temp = new NFA(state, state+1);
		temp.listState.add(new Node(state,true,false));
		temp.listState.getFirst().transitionList.add(new Transitions(state, 'E',var1.startState));
		temp.listState.getFirst().transitionList.add(new Transitions(state, 'E',var2.startState));
		var1.listState.getLast().transitionList.add(new Transitions(var1.finalState, 'E', temp.finalState));
		var2.listState.getLast().transitionList.add(new Transitions(var2.finalState, 'E', temp.finalState));
		temp.listState.addAll(var1.listState);
		temp.listState.addAll(var2.listState);
		temp.listState.add(new Node(state+1,false,true));
		return temp;
	}

	public static NFA star(NFA star, int state) {
		NFA temp;
		temp = new NFA ( state, state);
		star.listState.getLast().transitionList.add(new Transitions(star.finalState, 'E', temp.finalState));
		temp.listState.addAll(star.listState);
		temp.listState.add(new Node(state,true,true));
		temp.listState.getLast().transitionList.add(new Transitions(state, 'E', star.startState));
		return temp;
	}

}

