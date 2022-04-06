package htree;

import static turtle.Turtle.*;


/**
 * A class that use Turtle graphics to make H-tree with recursion.
 * @author Faisal Alzahrany
 */

public class HTree {
    public static final int MAX_SEGMENT_LENGTH=200;

    public static void init(int length, int depth){
        Turtle.setWorldCoordinates(-length*2,-length*2,length*2,length*2);
        Turtle.title("H-Tree, depth: " + depth);
        Turtle.speed(0);

    }

    /**
     * This method recursively draw H-tree.
     * @param length the length of the current h-tree segments
     * @param depth the current depth of recursion
     */
    public static void drawHtree(double length, int depth){
        if (depth<1){
            return;
        }
        else {
            Turtle.penDown();
            Turtle.forward(length/2);
            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.right(90);//right up side
            drawHtree(length/2, depth-1);
            Turtle.left(90);
            Turtle.forward(-length);
            Turtle.right(90);//right down side
            drawHtree(length/2, depth-1);

            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.right(90);
            Turtle.forward(-length);
            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.right(90);// left up side
            drawHtree(length/2, depth-1);

            Turtle.left(90);
            Turtle.forward(-length);
            Turtle.right(90);// left down side
            drawHtree(length/2, depth-1);

            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.right(90);
            Turtle.forward(length/2);// back to the centre
        }



    }

    /**
     this is the main method prompt the user to enter number of depths and use it in drawHtree method.
     */
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please enter a number for depths: ");
        int number = scanner.nextInt();
        init(MAX_SEGMENT_LENGTH,number);
        drawHtree(MAX_SEGMENT_LENGTH, number);
    }

}
