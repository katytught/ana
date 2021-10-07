import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class getsym {
    static String reserver(String s){
        if(s.equals("if")){
            return "If";
        }
        else if(s.equals("else")){
            return "Else";
        }
        else if(s.equals("while")){
            return "While";
        }
        else if(s.equals("break")){
            return "Break";
        }
        else if(s.equals("continue")){
            return "Continue";
        }
        else if(s.equals("return")){
            return "Return";
        }
        else {
            return null;
        }
    }
    static String getsys(String s){
        for(int i=0;i<s.length();i++){
            StringBuilder token= new StringBuilder();
            String type="";
            if(Character.isSpaceChar(s.charAt(i))||s.charAt(i)=='\t'){

            }
            else if(Character.isLetter(s.charAt(i))||s.charAt(i)=='_'){
                while (Character.isLetter(s.charAt(i))||s.charAt(i)=='_'||Character.isDigit(s.charAt(i))){
                    token.append(s.charAt(i));
                    i++;
                    if(i>=s.length()){
                        break;
                    }
                }
                i--;
                String temp = token.toString();
                temp = reserver(temp);
                if(temp == null){
                    System.out.println("Ident(" + token.toString() + ")");
                }
                else {
                    System.out.println(temp);
                }
            }
            else if(Character.isDigit(s.charAt(i))){
                while (Character.isDigit(s.charAt(i))){
                    token.append(s.charAt(i));
                    i++;
                    if(i>=s.length()){
                        break;
                    }
                }
                i--;
                String temp = "Number(" + token.toString() + ")";
                System.out.println(temp);
            }
            else if(s.charAt(i)=='='){
                i++;
                if(i>=s.length()){
                    token.append("Assign");
                    i--;
                }
                else if(s.charAt(i)=='='){
                    token.append("Eq");
                }
                else {
                    token.append("Assign");
                    i--;
                }
                System.out.println(token.toString());
            }
            else if(s.charAt(i)==';'){
                token.append("Semicolon") ;
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='('){
                token.append("LPar");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)==')'){
                token.append("RPar");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='{'){
                token.append("LBrace");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='}'){
                token.append("RBrace");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='+'){
                token.append("Plus");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='*'){
                token.append("Mult");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='/'){
                token.append("Div");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='<'){
                token.append("Lt");
                System.out.println(token.toString());
            }
            else if(s.charAt(i)=='>') {
                token.append("Gt");
                System.out.println(token.toString());
            }
            else {
                token.append("Err");
                System.out.println(token.toString());
                System.exit(0);
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s= br.readLine())!=null){
            getsys(s);
        }
    }
}
