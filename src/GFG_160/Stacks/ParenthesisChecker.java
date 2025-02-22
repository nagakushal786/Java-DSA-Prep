package GFG_160.Stacks;

import java.util.*;

public class ParenthesisChecker {
    public static boolean parenthesisChecker(String s){
        Stack<Character> st=new Stack<>();

        for(char ch: s.toCharArray()){
            if(st.isEmpty() || ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if((ch==')' && st.peek()=='(') || (ch=='}' && st.peek()=='{') || (ch==']' && st.peek()=='[')){
                st.pop();
            }else{
                return false;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args){
        String s="[()()]{";

        boolean res=parenthesisChecker(s);
        System.out.println(res);
    }
}
