package packUnit;

import packMain.interfaceMain;

public class clsUnit implements interfaceMain, Comparable<clsUnit>
{
	private int ID;
	private float localPrice;
	private String warehouseCity;
	private float cadPrice;
	private int qtyOnHand;
	private String itemDsc;
	private float totalPrice;

	public float computeCadPrice(float localPrice, String warehourseCity)
	{
		switch (warehouseCity.toLowerCase())
		{
		case "new york":
		{
			return (float) (USD_CAN * localPrice);
		}
		case "barcelona":
		{
			return (float) (EUR_CAN * localPrice);
		}
		default: 
		{
			return localPrice;
		}
		}
	}

	public float computeTotal(float cadPrice, int qtyOnHand)
	{
		return (float) (cadPrice * qtyOnHand);
	}

	public clsUnit(int ID, float localPrice, String warehouseCity, int qtyOnHand, String itemDsc)
	{
		this.ID = ID;
		this.localPrice = localPrice;
		this.warehouseCity = warehouseCity;
		this.qtyOnHand = qtyOnHand;
		this.itemDsc = itemDsc;
		this.cadPrice = computeCadPrice(localPrice, warehouseCity);
		this.totalPrice = computeTotal(cadPrice, qtyOnHand);
	}

	public int getID()
	{
		return ID;
	}

	public double getLocalPrice()
	{
		return localPrice;
	}

	public String getWarehouseCity()
	{
		return warehouseCity;
	}

	public double getCadPrice()
	{
		return cadPrice;
	}

	public int getQtyOnHand()
	{
		return qtyOnHand;
	}

	public String getItemDsc()
	{
		return itemDsc;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	@Override
	public int compareTo(clsUnit o) 
	{
		if (this.getCadPrice() > o.getCadPrice()) { return NUM_1; }
		else if (this.getCadPrice() < o.getCadPrice()) { return -1; }
		else { return NUM_0; }
	}

}
