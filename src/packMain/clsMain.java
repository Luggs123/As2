package packMain;
// TODO: Write program function.
/*** Program Function; 
 *** Creator; Paul Gaudnik, Mark Jarjour, Michael Luger
 *** Submission Date; October 10th, 2016
 *** Date Last Modified; October 10th, 2016
 ***/

import packUnit.*;

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
	private static TreeMap<Integer, clsUnit> unitMap = new TreeMap<>();

	// Text fields.
	private JTextField unitIDField;
	private JTextField descField;
	private JTextField qtyField;

	private JTextField cadField;
	private JTextField usdField;
	private JTextField eurField;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public clsMain() 
	{
		setTitle("Enter Unit Information");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

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

		JLabel lblWarehouse = new JLabel("Warehouse:");
		lblWarehouse.setBounds(6, 92, 77, 16);
		panel.add(lblWarehouse);

		JRadioButton rdbtnMontreal = new JRadioButton("Montreal");
		buttonGroup.add(rdbtnMontreal);
		rdbtnMontreal.setBounds(95, 88, 87, 23);
		rdbtnMontreal.setActionCommand("cad");
		rdbtnMontreal.addActionListener(new rdbtnListener());
		panel.add(rdbtnMontreal);

		JRadioButton rdbtnNewYork = new JRadioButton("New York");
		buttonGroup.add(rdbtnNewYork);
		rdbtnNewYork.setBounds(194, 88, 92, 23);
		rdbtnNewYork.setActionCommand("usd");
		rdbtnNewYork.addActionListener(new rdbtnListener());
		panel.add(rdbtnNewYork);

		JRadioButton rdbtnBarcelona = new JRadioButton("Barcelona");
		buttonGroup.add(rdbtnBarcelona);
		rdbtnBarcelona.setBounds(297, 88, 92, 23);
		rdbtnBarcelona.setActionCommand("eur");
		rdbtnBarcelona.addActionListener(new rdbtnListener());
		panel.add(rdbtnBarcelona);

		JLabel lblUnitPrice = new JLabel("Unit Price:");
		lblUnitPrice.setBounds(6, 131, 77, 16);
		panel.add(lblUnitPrice);

		cadField = new JTextField();
		cadField.setBounds(95, 126, 87, 26);
		panel.add(cadField);

		usdField = new JTextField();
		usdField.setBounds(194, 126, 91, 26);
		panel.add(usdField);

		eurField = new JTextField();
		eurField.setBounds(297, 126, 92, 26);
		panel.add(eurField);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(115, 179, 77, 29);
		btnClear.addActionListener(new btnListenerCLEAR());
		panel.add(btnClear);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(227, 179, 68, 29);
		panel.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(311, 179, 77, 29);
		panel.add(btnDelete);

		JButton btnSearchById = new JButton("Search by ID");
		btnSearchById.setBounds(98, 220, 117, 29);
		btnSearchById.addActionListener(new btnListenerSEARCH());
		panel.add(btnSearchById);

		JButton btnDone = new JButton("Done");
		btnDone.setBounds(321, 220, 68, 29);
		panel.add(btnDone);

		JButton btnMore = new JButton("More");
		btnMore.setBounds(227, 220, 68, 29);
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
			int searchUnit = NUM_0;
			
			try
			{  
				// Parse text field.
				searchUnit = Integer.parseInt(unitIDField.getText());
			}
			
			catch (NumberFormatException nfe)
			{ 
				// If an error is caught then throw an error dialog.
				JOptionPane.showMessageDialog(null, "Please enter a valid \"Unit ID\" parameter." , "Input Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			for (Map.Entry<Integer, clsUnit> map : unitMap.entrySet())
			{
				if (searchUnit == map.getKey())
				{
					// TODO: Disable every button and enable the edit and delete buttons.
					// Display unit info and disable text fields.
					descField.setEditable(false);
					qtyField.setEditable(false);
					cadField.setEditable(false);
					usdField.setEditable(false);
					eurField.setEditable(false);
					
					descField.setText(map.getValue().getItemDsc());
					qtyField.setText(Integer.toString(map.getValue().getQtyOnHand()));
					cadField.setText(Double.toString(map.getValue().getCadPrice()));
					return;
				}
			}
			
			// If the unit doesn't exist then throw an error dialog.
			JOptionPane.showMessageDialog(null, "No unit with that ID was found in the database.", "ID Does Not Exist", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args)
	{
		clsMain frame = new clsMain();
		frame.setSize(700, 410);
		frame.setVisible(true);
	}
}
