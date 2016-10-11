package packEmployee;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class clsEmployee
{
	public String name;
	public int ID;
	public GregorianCalendar loginDate;
	public String dateOutput;
	
	public clsEmployee(String name, int iD, GregorianCalendar loginDate)
	{
		this.name = name;
		this.ID = iD;
		this.loginDate = new GregorianCalendar();
		this.dateOutput = loginDate.get(Calendar.DAY_OF_MONTH) + "-" + loginDate.get(Calendar.MONTH) + "-" + loginDate.get(Calendar.YEAR);
	}
	
	
}
