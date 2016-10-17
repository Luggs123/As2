package packMain;

import java.util.Map;
import java.util.TreeMap;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import packUnit.clsUnit;

public class clsReport extends JFrame implements interfaceMain
{
	private static final long serialVersionUID = -5812478219799894245L;
	private static Map<Integer, clsUnit> unitMap = new TreeMap<Integer, clsUnit>(clsMain.sortByValues(clsMain.unitMap));
	
	protected String[][] tableInventory;
	protected int unitTotals = NUM_0;
	
	public clsReport()
	{
		setTitle("Yearly Inventory Report");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout());
		
		// Convert map of unit entries into a two-dimensional string.
		tableInventory = new String[unitMap.entrySet().size()][6];
		int entryNum = NUM_0;
		for (Map.Entry<Integer, clsUnit> entry : unitMap.entrySet())
		{
			tableInventory[entryNum][0] = Integer.toString(entry.getKey());
			tableInventory[entryNum][1] = entry.getValue().getItemDsc();
			tableInventory[entryNum][2] = Integer.toString(entry.getValue().getQtyOnHand());
			tableInventory[entryNum][3] = Float.toString((float) (Math.round(entry.getValue().getCadPrice() * NUM_100) / NUM_100)); // Round price because float.
			tableInventory[entryNum][4] = entry.getValue().getWarehouseCity();
			tableInventory[entryNum][5] = Float.toString((float) (Math.round(entry.getValue().getTotalPrice() * NUM_100) / NUM_100)); // Round price because float.
			unitTotals += Float.parseFloat(tableInventory[entryNum][5]);
			
			entryNum++;
		}
		
		String[] columnNames = {"Unit ID", "Description", "Qty On Hand", "Unit Price", "Warehouse City", "Total (CAD)"};
		
		JTable inventoryReport = new JTable(tableInventory, columnNames);
		inventoryReport.setEnabled(false);

		panel.add(new JScrollPane(inventoryReport));
	}
}
