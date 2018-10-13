import java.util.*;
import java.io.*;  

public class Main{

    public static void main(String[] args) {
        Start();
    }

    public static void Start(){
        try{
        FileInputStream fstream = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int i = 0;
        while ((strLine = br.readLine()) != null) {
            // Print the content on the console
            System.out.println("Test number: " + i);
            System.out.println (strLine);
            i++;
            Case(strLine);
        }
        }catch(Exception e){System.out.println(e);}    

        // System.out.println("Type regular expression in postfix: ");
        // Scanner reader;
        // reader = new Scanner(System.in);
        // String str = reader.nextLine();
        // Case(str);
    }

    public static void Case(String str){
        int state = 0;
        Stack<NFA> myStack;
        myStack = new Stack<NFA>();
        int i = 0;
        while (true) {
            if (i >= str.length()) break;
            char letter = str.charAt(i);
            if (letter == '*'){
                NFA star = myStack.pop();
                star = NFA.star(star, state);
                myStack.push(star);
                state++;
            } else if(letter == '|'){
                NFA var1 = myStack.pop();
                NFA var2 = myStack.pop();
                NFA union = NFA.union(var1, var2, state);
                myStack.push(union);
                state += 2;
            } else if(letter == '&'){
                NFA var1 = myStack.pop();
                NFA var2 = myStack.pop();
                NFA union = NFA.union(var1, var2, state);
                myStack.push(union);
            } else{
                NFA alphaL = NFA.alphaLetter(letter, state);
                myStack.push(alphaL);
                state += 2;
            }
            i++;
        }
        NFA last;
        last = myStack.pop();
        last.printNFA();
    }
}