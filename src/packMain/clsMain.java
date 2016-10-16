package packMain;
// TODO: Write program function.
/*** Program Function;
 *** Creator; Paul Gaudnik, Mark Jarjour, Michael Luger
 *** Submission Date; October 10th, 2016
 *** Date Last Modified; October 10th, 2016
 ***/

import packUnit.*;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class clsMain extends JFrame implements interfaceMain
{
	private static final long serialVersionUID = -1784204695438064302L;
	private static Map<Integer, clsUnit> unitMap = new TreeMap<>();

	// Text fields.
	static JTextField unitIDField;
	static JTextField descField;
	static JTextField qtyField;

	static JTextField cadField;
	static JTextField usdField;
	static JTextField eurField;

	// Buttons.
	final static JButton btnClear = new JButton("Clear");
	final static JButton btnEdit = new JButton("Edit");
	final static JButton btnDelete = new JButton("Delete");
	final static JButton btnSearchById = new JButton("Search by ID");
	final static JButton btnDone = new JButton("Done");
	final static JButton btnMore = new JButton("More");

	final static JRadioButton rdbtnMontreal = new JRadioButton("Montreal");
	final static JRadioButton rdbtnNewYork = new JRadioButton("New York");
	final static JRadioButton rdbtnBarcelona = new JRadioButton("Barcelona");

	private final ButtonGroup buttonGroup = new ButtonGroup();

	public clsMain()
	{
		setTitle("Enter Unit Information");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		// Unit labels and text fields.
		JLabel unitIDLabel = new JLabel("Unit ID:");
		unitIDLabel.setBounds(6, 6, 48, 16);
		panel.add(unitIDLabel);

		unitIDField = new JTextField();
		unitIDField.setBounds(66, 1, 77, 26);
		panel.add(unitIDField);

		JLabel descLabel = new JLabel("Description:");
		descLabel.setBounds(159, 6, 77, 16);
		panel.add(descLabel);

		descField = new JTextField();
		descField.setBounds(248, 1, 130, 26);
		panel.add(descField);

		JLabel qtyLabel = new JLabel("Qty on hand:");
		qtyLabel.setBounds(390, 6, 81, 16);
		panel.add(qtyLabel);

		qtyField = new JTextField();
		qtyField.setBounds(483, 1, 87, 26);
		panel.add(qtyField);

		// Warehouse radio buttons.
		JLabel lblWarehouse = new JLabel("Warehouse:");
		lblWarehouse.setBounds(6, 92, 77, 16);
		panel.add(lblWarehouse);

		buttonGroup.add(rdbtnMontreal);
		rdbtnMontreal.setBounds(95, 88, 87, 23);
		rdbtnMontreal.setActionCommand("cad");
		rdbtnMontreal.addActionListener(new rdbtnListener());
		panel.add(rdbtnMontreal);

		buttonGroup.add(rdbtnNewYork);
		rdbtnNewYork.setBounds(194, 88, 92, 23);
		rdbtnNewYork.setActionCommand("usd");
		rdbtnNewYork.addActionListener(new rdbtnListener());
		panel.add(rdbtnNewYork);

		buttonGroup.add(rdbtnBarcelona);
		rdbtnBarcelona.setBounds(297, 88, 92, 23);
		rdbtnBarcelona.setActionCommand("eur");
		rdbtnBarcelona.addActionListener(new rdbtnListener());
		panel.add(rdbtnBarcelona);

		JLabel lblUnitPrice = new JLabel("Unit Price:");
		lblUnitPrice.setBounds(6, 131, 77, 16);
		panel.add(lblUnitPrice);

		// Currency text fields.
		cadField = new JTextField();
		cadField.setBounds(95, 126, 87, 26);
		panel.add(cadField);

		usdField = new JTextField();
		usdField.setBounds(194, 126, 91, 26);
		panel.add(usdField);

		eurField = new JTextField();
		eurField.setBounds(297, 126, 92, 26);
		panel.add(eurField);

		// Buttons.
		btnClear.setBounds(115, 179, 77, 29);
		btnClear.addActionListener(new btnListenerCLEAR());
		panel.add(btnClear);

		btnEdit.setBounds(227, 179, 68, 29);
		btnEdit.setEnabled(false);
		btnEdit.addActionListener(new btnListenerEDIT());
		panel.add(btnEdit);

		btnDelete.setBounds(311, 179, 77, 29);
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new btnListenerDELETE());
		panel.add(btnDelete);

		btnSearchById.setBounds(98, 220, 117, 29);
		btnSearchById.addActionListener(new btnListenerSEARCH());
		panel.add(btnSearchById);

		btnDone.setBounds(321, 220, 68, 29);
		panel.add(btnDone);

		btnMore.setBounds(227, 220, 68, 29);
		btnMore.addActionListener(new btnListenerMORE());
		panel.add(btnMore);

	}

	class rdbtnListener implements ActionListener // Open and close text fields based on the location selected.
	{
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand())
			{
			case "cad":
			{
				cadField.setEditable(true);
				usdField.setEditable(false);
				eurField.setEditable(false);
				break;
			}

			case "usd":
			{
				cadField.setEditable(false);
				usdField.setEditable(true);
				eurField.setEditable(false);
				break;
			}

			case "eur":
			{
				cadField.setEditable(false);
				usdField.setEditable(false);
				eurField.setEditable(true);
				break;
			}
			}
		}

	}

	class btnListenerCLEAR implements ActionListener // Clears text fields.
	{
		public void actionPerformed(ActionEvent e)
		{
			unitIDField.setText(EMPTY_STR);
			descField.setText(EMPTY_STR);
			qtyField.setText(EMPTY_STR);
			cadField.setText(EMPTY_STR);
			usdField.setText(EMPTY_STR);
			eurField.setText(EMPTY_STR);
		}
	}

	class btnListenerSEARCH implements ActionListener // Searches for and displays the unit based on the ID, if it exists.
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!catchNumberFormatError(unitIDField, "Please enter a valid \"Unit ID\" parameter.")) { return; }

			int searchUnit = Integer.parseInt(unitIDField.getText());

			for (Map.Entry<Integer, clsUnit> map : unitMap.entrySet())
			{
				if (searchUnit == map.getKey())
				{
					// Display unit info and disable text fields.
					descField.setText(map.getValue().getItemDsc());
					qtyField.setText(Integer.toString(map.getValue().getQtyOnHand()));
					cadField.setText(Float.toString((float) (Math.round(map.getValue().getCadPrice() * NUM_100) / NUM_100))); // Round price because float.

					rdbtnMontreal.doClick();
					viewMode(true);
					return;
				}
			}

			// If the unit doesn't exist then throw an error dialog.
			JOptionPane.showMessageDialog(null, "No unit with that ID was found in the database.", "ID Does Not Exist", JOptionPane.ERROR_MESSAGE);
		}
	}

	class btnListenerEDIT implements ActionListener // Lets the user edit the unit found with "Search by ID".
	{
		public void actionPerformed(ActionEvent e)
		{
			viewMode(false);
		}

	}

	class btnListenerDELETE implements ActionListener // Lets the user remove the unit found with "Search by ID" from the database.
	{
		public void actionPerformed(ActionEvent e)
		{
			unitMap.remove(Integer.parseInt(unitIDField.getText()));

			viewMode(false);
			btnClear.doClick();
		}

	}

	class btnListenerMORE implements ActionListener // Searches for and displays the unit based on the ID, if it exists.
	{
		public void actionPerformed(ActionEvent e)
		{
			// Check for errors in the input fields.
			if (!catchNumberFormatError(unitIDField, "Please enter a valid \"Unit ID\" parameter.")) { return; }
			if (!catchNumberFormatError(qtyField, "Please enter a valid \"Qty on Hand\" parameter.")) { return; }
			int unitID = Integer.parseInt(unitIDField.getText());
			int qty = Integer.parseInt(qtyField.getText());

			if (unitID < NUM_100 || unitID > 999)
			{
				JOptionPane.showMessageDialog(null, "Unit ID must be between 100 and 999.", "Unit ID Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (descField.getText().length() > 10)
			{
				JOptionPane.showMessageDialog(null, "Item description can only be 10 characters or less. (Your input contained " + descField.getText().length() + ")", "Item Description Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (qty < NUM_0 || qty > 9999)
			{
				JOptionPane.showMessageDialog(null, "Qty on Hand must be between 0 and 9999.", "Quantity Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String warehouseCity = EMPTY_STR;
			float unitPrice = NUM_0;
			if (rdbtnNewYork.isSelected())
			{
				warehouseCity = "New York";
				if (!catchNumberFormatError(usdField, "Please enter a valid \"Unit Price\" parameter.", true)) { return; }
				unitPrice = Float.parseFloat(usdField.getText());
			}
			else if (rdbtnBarcelona.isSelected())
			{
				warehouseCity = "Barcelona";
				if (!catchNumberFormatError(eurField, "Please enter a valid \"Unit Price\" parameter.", true)) { return; }
				unitPrice = Float.parseFloat(eurField.getText());
			}
			else
			{
				warehouseCity = "Montreal";
				if (!catchNumberFormatError(cadField, "Please enter a valid \"Unit Price\" parameter.", true)) { return; }
				unitPrice = Float.parseFloat(cadField.getText());
			}

			if (unitPrice <= NUM_0)
			{
				JOptionPane.showMessageDialog(null, "Unit Price must be a positive value.", "Unit Price Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// TODO: Make the map sort by unit price.
			// Add information to map.
			unitMap.put(unitID, new clsUnit(unitPrice, warehouseCity, qty, descField.getText()));

			// Clear text fields.
			btnClear.doClick();
		}
	}
	
	class btnListenerDONE implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			unitMap = sortByValues(unitMap);
			// TODO Auto-generated method stub
		}
	}

	public static void main(String[] args)
	{
		clsMain frame = new clsMain();
		rdbtnMontreal.doClick();
		frame.setSize(700, 410);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Function used for catching errors involving incorrect data being inputed into text fields.
	public static Boolean catchNumberFormatError(JTextField textfield, String errorMessage)
	{
		try
		{
			// Parse text field.
			Integer.parseInt(textfield.getText());
		}

		catch (NumberFormatException nfe)
		{
			// If an error is caught then throw an error dialog.
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	// Variant of the previous function for floats.
	public static Boolean catchNumberFormatError(JTextField textfield, String errorMessage, Boolean isFloat)
	{
		try
		{
			// Parse text field.
			Float.parseFloat(textfield.getText());
		}

		catch (NumberFormatException nfe)
		{
			// If an error is caught then throw an error dialog.
			JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	// Toggles whether the buttons and text fields are usable.
	public static void viewMode(Boolean enable)
	{
		rdbtnMontreal.setEnabled(!enable);
		rdbtnNewYork.setEnabled(!enable);
		rdbtnBarcelona.setEnabled(!enable);

		unitIDField.setEditable(!enable);
		descField.setEditable(!enable);
		qtyField.setEditable(!enable);

		// Toggle buttons so that "Edit" and "Delete" are always in the opposite state.
		btnClear.setEnabled(!enable);
		btnEdit.setEnabled(enable);
		btnDelete.setEnabled(enable);
		btnSearchById.setEnabled(!enable);
		btnDone.setEnabled(!enable);
		btnMore.setEnabled(!enable);

		// This prevents all three local price fields from being opened.
		if (enable)
		{
			cadField.setEditable(false);
			usdField.setEditable(false);
			eurField.setEditable(false);
		}
		else
		{
			cadField.setEditable(true);
			usdField.setEditable(false);
			eurField.setEditable(false);
		}
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) 
	{
		Comparator<K> valueComparator =  new Comparator<K>() 
		{
			public int compare(K k1, K k2) 
			{
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0) return 1;
				else return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
}
