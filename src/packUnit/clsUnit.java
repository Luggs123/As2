package packUnit;

import packMain.interfaceMain;

public class clsUnit implements interfaceMain
{
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

	public clsUnit(float localPrice, String warehouseCity, int qtyOnHand, String itemDsc)
	{
		this.localPrice = localPrice;
		this.warehouseCity = warehouseCity;
		this.qtyOnHand = qtyOnHand;
		this.itemDsc = itemDsc;
		this.cadPrice = computeCadPrice(localPrice, warehouseCity);
		this.totalPrice = computeTotal(cadPrice, qtyOnHand);
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

}
