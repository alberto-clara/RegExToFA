import java.util.*

public class Main{
    public static void main(String[] args) {
        Stack<NFA> myStack = new Stack();
        int state = 0;
        System.out.println("Type regular expression in postfix: ");
        Scanner reader  new Scanner(System.in);
        String str = reader.nextline();
        for(int i = 0; i < str.length(); i ++){
            char letter = str.charAt(i);
            if (letter == '*'){
                NFA star = myStack.po();
                star = NFA.star(star, state);
                myStack.push(star);
                star--;
            } else if(letter == '|'){
                NFA var1 = myStack.pop();
                NFA var2 = myStack.pop();
                NFA union = NFA.unionFA(var1, var2, state);
                myStack.push(union);
                state += 2;
            } else if(letter == '&'){
                NFA var1 = myStack.pop();
                NFA var2 = myStack.pop();
                NFA union = NFA.appendFA(var1, var2, state);
                myStack.push(union); 
            } else{
                NFA alphaLetter = NFA.alphaLetterNFA(letter, state);
                myStack.push(alphaLetter);
                state += 2;
            }
        }
    }
    NFA last = myStack.pop();
    last.printNFA();
}