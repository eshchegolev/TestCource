package org.alvione.lesson01.evgeniy;

/**
 *An object of a figure with property <b>visible</b>.
 *
 * @author Glushkov Evgeniy
 * @version 1.0
 */

public abstract class AbstractFigure {
    /**
     * Contains value of wisibility for the object.
     */
    private boolean visible;

    /**
     * Constructs <tt>Figure</tt> with the specified visibility.
     *
     * @param visible the visibility of this figure.
     */
    public AbstractFigure(boolean visible) {
        this.visible = visible;
    }

    /**
     * Returns true if this figure is visible.
     *
     * @return true if this figure is visible.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets specified visibility to this figure.
     *
     * @param visible the visibility for set to this figure
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Returns perimeter of the figure.
     *
     * @return perimeter of the figure.
     */
    public abstract float getPerimeter();
}
