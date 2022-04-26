package application;

public class Board {

	public RectangleTec arr[] ;
	
	
	public Board()
	{
		arr = new RectangleTec[9];
	}
	
	
	public int getSize()
	{
		return arr.length;
	}
	
	
	public boolean isFull(int index) {
		return arr[index].xo != '\0';
	}
	
	public void setValue(int index, char value)
	{
		arr[index].xo = value;
	}
	
	public boolean anySpace()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			if(arr[i].xo == '\0')
				return true;
		}
		
		return false;
	}
	
	public String toString()
	{
		return arr[0].xo + " | " + arr[1].xo + " | " + arr[2].xo + "\n" +
				arr[3].xo + " | " + arr[4].xo + " | " + arr[5].xo + "\n" +
				arr[6].xo + " | " + arr[7].xo + " | " + arr[8].xo + "\n" ;
	}
	
}
