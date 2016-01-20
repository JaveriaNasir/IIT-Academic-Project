package edu.iit.itmd510;

public class Stocks
{
	private String SKU;
	private String description;
	private String OfferType;
	private double unitCost;
	private int discount;
	private int buy;
	private int Xbuy;
	private int Ycost;
	
	public Stocks(String SKU,String Desc,int cost)
	{
		this.SKU = SKU;
		this.description = Desc;
		this.unitCost = cost;
	}
	
	public void setsku(String sku)
	{
		this.SKU = sku;
	}
	public String getsku()
	{
		return SKU;
	}
	public void setdescription(String description)
	{
		this.description = description;
	}
	public String getdescription()
	{
		return description;
	}
	public void setunitcost(int unitcost)
	{
		this.unitCost = unitcost;
	}
	public double getunitcost()
	{
		return unitCost;
	}	
	public void setOffertype(String offertype)
	{
		this.OfferType = offertype;
	}
	public String getOffertype()
	{
		return OfferType;
	}
	public void setDiscount(int discount)
	{
		this.discount = discount;
	}
	public int getDiscount()
	{
		return discount;
	}
	public void setBuy(int buy)
	{
		this.buy = buy;
	}
	public int getBuy()
	{
		return buy;
	}
	public void setXbuy(int x)
	{
		this.Xbuy = x;
	}
	public int getxbuy()
	{
		return Xbuy;
	}
	public void setycost(int y)
	{
		this.Ycost = y;
	}
	public int getycost()
	{
		return Ycost;
	}

}
