package test2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TEH_METHIOD extends JFrame {
	// Text fields.
	private JTextField unitIDField;
	private JTextField textField;
	private JTextField qtyField;
	
	public TEH_METHIOD() {
		setTitle("Enter Unit Information");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Description = new JLabel("Unit ID:");
		Description.setBounds(6, 7, 48, 27);
		panel.add(Description);
		
		unitIDField = new JTextField();
		unitIDField.setBounds(66, 7, 130, 26);
		panel.add(unitIDField);
		unitIDField.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(285, 7, 130, 26);
		panel.add(textField);
		
		JLabel descLabel = new JLabel("Description:");
		descLabel.setBounds(208, 6, 65, 28);
		panel.add(descLabel);
		
		JLabel warehouseLabel = new JLabel("Warehouse:");
		warehouseLabel.setBounds(6, 75, 77, 16);
		panel.add(warehouseLabel);
	}
}
