package packUnit;


public class clsUnit
{
    protected float unitPrice;
    protected int qtyOnHand;
    protected String itemDsc;
    protected String warehouseCity;
   
    
    public double computeTotal(float unitPrice, int qtyOnHand)
    {
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        double cadTotal = (unitPrice * qtyOnHand);
        
        /* Computes the total cost of a Unit by multiplying the quantity on hand 
           in warehouse by the unit price(in CAD). 
        */ 
        return cadTotal;
    }
    
}
