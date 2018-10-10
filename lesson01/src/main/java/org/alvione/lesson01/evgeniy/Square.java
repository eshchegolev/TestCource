package org.alvione.lesson01.evgeniy;

/**
 *An object of a square with sides properties <b>sideA</b> and <b>sideB</b>.
 *
 * @author Glushkov Evgeniy
 * @version 1.0
 */

public class Square extends AbstractFigure {
    /**
     * Contains value of the first side of this square
     */
    private float sideA;
    /**
     * Contains value of the second side of this square
     */
    private float sideB;

    /**
     * Constructs <tt>square</tt> with the specified sides
     * and defaut visibility default value: false.
     *
     * @param sideA value of first side.
     * @param sideB value of second side.
     * @see Square#Square(boolean, float, float)
     */
    public Square(float sideA, float sideB) {
        this(false, sideA, sideB);
    }

    /**
     * Constructs <tt>square</tt> with the specified sides
     * and visibility
     *
     * @param visible the visibility of this square.
     * @param sideA value of first side.
     * @param sideB value of second side.
     * @see Square#Square(float, float)
     */
    public Square(boolean visible, float sideA, float sideB) {
        super(visible);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    /**
     * Returns value of first side.
     *
     * @return value of first side.
     */
    public float getSideA() {
        return sideA;
    }

    /**
     * Returns value of second side.
     *
     * @return value of second side.
     */
    public float getSideB() {
        return sideB;
    }

    /**
     * Sets specified value of first side.
     *
     * @param sideA value of first side.
     */
    public void setSideA(float sideA) {
        this.sideA = sideA;
    }

    /**
     * Sets specified value of second side.
     *
     * @param sideB value of second side
     */
    public void setSideB(float sideB) {
        this.sideB = sideB;
    }

    /**
     * Returns perimeter of the square.
     *
     * @return perimeter of the square.
     */
    @Override
    public float getPerimeter() {
        return (sideA + sideB) * 2;
    }
}
