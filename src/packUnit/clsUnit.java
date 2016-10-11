package packUnit;

import packMain.interfaceMain;

public class clsUnit implements interfaceMain
{
    protected double localPrice;
    protected String warehouseCity;
    protected double cadPrice;
    protected int qtyOnHand;
    protected String itemDsc;
    protected double totalPrice;
    
    public double computeCadPrice(float localPrice, String warehourseCity)
    {
    	switch (warehouseCity.toLowerCase())
    	{
    	case "montreal":
    		{
    			return CAN_CAN * localPrice;
    		}
    	case "new york":
    		{
    			return USD_CAN * localPrice;
    		}
    	case "barcelona":
    		{
    			return EUR_CAN * localPrice;
    		}
    	default: 
    		{
    			return localPrice;
    		}
    	}
    }
    
    public double computeTotal(double cadPrice, int qtyOnHand)
    {
        return cadPrice * qtyOnHand;
    }

	public clsUnit(float localPrice, String warehouseCity, int qtyOnHand, String itemDsc) {
		super();
		this.localPrice = localPrice;
		this.warehouseCity = warehouseCity;
		this.qtyOnHand = qtyOnHand;
		this.itemDsc = itemDsc;
		this.cadPrice = computeCadPrice(localPrice, warehouseCity);
		this.totalPrice = computeTotal(cadPrice, qtyOnHand);
	}
    
}
