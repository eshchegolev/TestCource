package org.alvione.lesson01.evgeniy;

/**
 *The main class that contains an entry point of the app and perimeter calculation method.
 *
 * @author Glushkov Evgeniy
 * @version 1.0
 */

public class MainClass {
    /**
     * The main function of the application is the entry point.
     * Creates square and prints its perimeter.
     *
     * @param args library launch arguments from command line, fixed-length one-dimensional array.
     * @see MainClass#calcPerimeter(AbstractFigure)
     */
    public static void main(String[] args) {
        float sideA = 56.3f;
        float sideB = 33.7f;

        AbstractFigure square = new Square(true, sideA, sideB);

        System.out.println(calcPerimeter(square));
    }

    /**
     * Returns perimeter of the figure which the method gets as parameter.
     *
     * @param figure figure fo perimeter calculation.
     * @return perimeter of the figure which the method gets as parameter.
     */
    public static float calcPerimeter(AbstractFigure figure) {
        return figure.getPerimeter();
    }
}
