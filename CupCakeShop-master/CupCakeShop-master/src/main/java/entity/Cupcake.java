
package entity;


public class Cupcake
{
    private Topping t = null;
    private Bottom b = null;

    /**
     * Constructor of a Cupcake.
     * <p>
     * A Cupcake is made from a Topping and a Bottom.
     * @param t
     * @param b 
     */

    public Cupcake(Topping t, Bottom b)
    {
        this.t = t;
        this.b = b;
    }

    /**
     * Returns Bottom b.
     * @return b
     */
    public Bottom getB()
    {
        return b;
    }
    
    /**
     * Sets Bottom b.
     * @param b 
     */
    public void setB(Bottom b)
    {
        this.b = b;
    }

    /**
     * Returns Topping t.
     * @return 
     */
    public Topping getT()
    {
        return t;
    }

    /**
     * Sets Topping t.
     * @param t 
     */
    public void setT(Topping t)
    {
        this.t = t;
    }

    /**
     * Calculates full price of a Cupcake.
     * <p>
     * Gets Bottom price and Topping price and plus them for the full price.
     * @return 
     */
    public int getFullPrice()
    {
        return b.getPrice() + t.getPrice();
    }

    /**
     * Returns a Cupcake with Topping, Bottom and full price.
     * <p>
     * Creates a string containing Topping, Bottom, full price and DKK at the end, 
     * so the price is shown in DKK on the website.
     * @return 
     */
    @Override
    public String toString()
    {
        return "Cupcake: " + t + ", " +  b + ", Price: " + getFullPrice() + " DKK \n";
    }

    
}
