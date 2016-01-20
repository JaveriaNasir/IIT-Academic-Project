package edu.iit.itmd510;

public class CustomerDetails {

	private String firstName;
	private String lastName;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	private String customerZipCode;
	private int numberOfAdults;
	private int numberOfChildren;
	private int room;
	private String roomType;
	private boolean isVaccant;
	private String defaultRoomType;
	
	public CustomerDetails(String roomtype)
	{
		defaultRoomType = roomtype;
		isVaccant = true;
	}
	
	public String getDefaultroomtype()
	{
		return defaultRoomType;
	}
	
	public void setFirstName(String FN)
	{
		firstName = FN;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setlastName(String LN)
	{
		lastName = LN;
	}
	
	public String getlastName()
	{
		return lastName;
	}
	
	public void setcustomerAddress(String address)
	{
		customerAddress = address;
	}
	
	public String getcustomerAddress()
	{
		return customerAddress;
	}
	
	public void setcustomerCity(String city)
	{
		customerCity = city;
	}
	
	public String getcustomerCity()
	{
		return customerCity;
	}
	
	public void setcustomerState(String state)
	{
		customerState = state;
	}
	
	public String getcustomerState()
	{
		return customerState;
	}
	
	public void setcustomerZipCode(String zipcode)
	{
		customerZipCode = zipcode;
	}
	
	public String getcustomerZipCode()
	{
		return customerZipCode;
	}
	
	public void setnumberOfAdults(int adults)
	{
		numberOfAdults = adults;
	}
	
	public int getnumberOfAdults()
	{
		return numberOfAdults;
	}
	
	public void setnumberOfChildren(int children)
	{
		numberOfChildren = children;
	}
	
	public int getnumberOfChildren()
	{
		return numberOfChildren;
	}
	
	public void setroom(int Room)
	{
		room = Room;
	}
	
	public int getroom()
	{
		return room;
	}
	
	public void setroomType(String RoomType)
	{
		roomType = RoomType;
	}
	
	public String getroomType()
	{
		return roomType;
	}
	public void setIsv(boolean isV)
	{
		isVaccant = isV;
	}
	public boolean getIsV()
	{
		return isVaccant;
	}
}
