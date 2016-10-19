package packEmployee;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class clsEmployee
{

	public int ID;
	public String name;
	public GregorianCalendar loginDate;
	public String dateOutput;
	
	public clsEmployee(int iD, String name, GregorianCalendar loginDate)
	{
		this.ID = iD;
		this.name = name;
		this.loginDate = new GregorianCalendar();
		this.dateOutput = String.format("%02d", loginDate.get(Calendar.DAY_OF_MONTH)) + "-" + 
				String.format("%02d", loginDate.get(Calendar.MONTH)) + "-" + loginDate.get(Calendar.YEAR);
	}
	
	
}
