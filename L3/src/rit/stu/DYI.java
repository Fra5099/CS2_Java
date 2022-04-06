package rit.stu;

import rit.cs.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class that implement Derp Your Interpreter method
 * @author Faisal Alzahrany
 */

public class DYI {

    public static Expression parse(ArrayList<String> tokens){
        String frontNode=tokens.remove(0);
        if (frontNode.equals("+")){
            Expression left= parse(tokens);
            Expression right=parse(tokens);
            return new AddExpression(left,right);
        }
        if (frontNode.equals("-")){
            Expression left= parse(tokens);
            Expression right=parse(tokens);
            return new SubExpression(left,right);
        }
        if (frontNode.equals("*")){
            Expression left= parse(tokens);
            Expression right=parse(tokens);
            return new MulExpression(left,right);
        }
        if (frontNode.equals("/")){
            Expression left= parse(tokens);
            Expression right=parse(tokens);
            return new DivExpression(left,right);

        }
        if (frontNode.equals("%")){
            Expression left= parse(tokens);
            Expression right=parse(tokens);
            return new ModExpression(left,right);
        }
        else {
            return new IntExpression(Integer.parseInt(frontNode));
        }
    }

    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Derp Your Interpreter v1.0 :)");
        while (true){
            System.out.println("> ");
            String tokens = scanner.nextLine();
            if (tokens.equals("quit")){
                break;
            }
            ArrayList<String> t= new ArrayList<String>(Arrays.asList(tokens.split(" ")));
            Expression calc= parse(t);
            System.out.println("Emit: "+calc.emit());
            System.out.println("Evaluate: "+calc.evaluate());

        }

    }
}


