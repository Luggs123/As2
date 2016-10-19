package packMain;

import java.awt.GridLayout;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import packEmployee.clsEmployee;
import packUnit.clsUnit;

public class clsReport extends JFrame implements interfaceMain
{
	private static final long serialVersionUID = -5812478219799894245L;
	private static Map<Integer, clsUnit> unitMap = new TreeMap<Integer, clsUnit>(clsMain.sortByValues(clsMain.unitMap));
	clsUnit maxUnit = Collections.max(unitMap.values(), getTotalPriceComparator());
	clsUnit minUnit = Collections.min(unitMap.values(), getTotalPriceComparator());
	clsEmployee employeeInfo = clsEmployeeUI.employeeInfo;
	
	protected Object[][] tableInventory;
	protected float unitTotals = NUM_0;
	protected float montrealTotals = NUM_0;
	
	public clsReport()
	{
		setTitle("Yearly Inventory Report");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		setSize(750, 600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		// Convert map of unit entries into a two-dimensional string.
		tableInventory = new Object[unitMap.entrySet().size()][6];
		int entryNum = NUM_0;
		for (Map.Entry<Integer, clsUnit> entry : unitMap.entrySet())
		{
			tableInventory[entryNum][0] = entry.getKey();
			tableInventory[entryNum][1] = entry.getValue().getItemDsc();
			tableInventory[entryNum][2] = entry.getValue().getQtyOnHand();
			tableInventory[entryNum][3] = entry.getValue().getCadPrice();
			tableInventory[entryNum][4] = entry.getValue().getWarehouseCity();			
			tableInventory[entryNum][5] = entry.getValue().getTotalPrice();
			
			if (tableInventory[entryNum][4] == "Montreal")
			{
				montrealTotals += entry.getValue().getTotalPrice();
			}
			unitTotals += entry.getValue().getTotalPrice();
			
			// Adding decimal values to Unit Price and total to columns.
			tableInventory[entryNum][3] = String.format("$%.2f", tableInventory[entryNum][3]);
			tableInventory[entryNum][5] = String.format("$%.2f", tableInventory[entryNum][5]);					
			
			entryNum++;
		}
		
		String[] columnNames = {"Unit ID", "Description", "Qty On Hand", "Unit Price", "Warehouse City", "Total (CAD)"};
		panel.setLayout(null);
		
		JTable inventoryReport = new JTable(tableInventory, columnNames);
		inventoryReport.setEnabled(false);
		inventoryReport.getTableHeader().setReorderingAllowed(false);
		inventoryReport.getTableHeader().setResizingAllowed(false);
		
		JScrollPane reportScrollPane = new JScrollPane(inventoryReport);
		reportScrollPane.setBounds(57, 47, 600, 300);
		panel.add(reportScrollPane);
		
		JLabel lblTotal = new JLabel("Report Total: " + String.format("$%.2f", unitTotals));
		lblTotal.setBounds(57, 360, 180, 16);
		panel.add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("Employee ID: " + employeeInfo.ID + ", Employee Name: " 
				+ employeeInfo.name + ", Date: " + employeeInfo.dateOutput + ".");
		lblNewLabel.setBounds(57, 13, 600, 16);
		panel.add(lblNewLabel);
		
		
	}
	
	public Comparator<clsUnit> getTotalPriceComparator()
	{
		return new Comparator<clsUnit>()
		{
			public int compare(clsUnit c1, clsUnit c2)
			{
				if (c1.getTotalPrice() > c2.getTotalPrice())
				{
					return 1;
				}
				else if (c1.getTotalPrice() < c2.getTotalPrice())
				{
					return -1;
				}
				else {
					return 0;
				}
			}
		};
	}
}
