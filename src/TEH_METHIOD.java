import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TEH_METHIOD extends JFrame {
	
	// Text fields.
	private JTextField unitIDField;
	private JTextField descField;
	private JTextField qtyField;
	
	private JTextField cndField;
	private JTextField usdField;
	private JTextField eurField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public TEH_METHIOD() {
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
		panel.add(rdbtnMontreal);
		
		JRadioButton rdbtnNewYork = new JRadioButton("New York");
		buttonGroup.add(rdbtnNewYork);
		rdbtnNewYork.setBounds(194, 88, 92, 23);
		panel.add(rdbtnNewYork);
		
		JRadioButton rdbtnBarcelona = new JRadioButton("Barcelona");
		buttonGroup.add(rdbtnBarcelona);
		rdbtnBarcelona.setBounds(297, 88, 92, 23);
		panel.add(rdbtnBarcelona);
		
		JLabel lblUnitPrice = new JLabel("Unit Price:");
		lblUnitPrice.setBounds(6, 131, 77, 16);
		panel.add(lblUnitPrice);
		
		cndField = new JTextField();
		cndField.setBounds(95, 126, 87, 26);
		panel.add(cndField);
		
		usdField = new JTextField();
		usdField.setBounds(194, 126, 91, 26);
		panel.add(usdField);
		
		eurField = new JTextField();
		eurField.setBounds(297, 126, 92, 26);
		panel.add(eurField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(115, 179, 77, 29);
		panel.add(btnClear);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(227, 179, 68, 29);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(311, 179, 77, 29);
		panel.add(btnDelete);
		
		JButton btnSearchById = new JButton("Search by ID");
		btnSearchById.setBounds(98, 220, 117, 29);
		panel.add(btnSearchById);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(321, 220, 68, 29);
		panel.add(btnDone);
		
		JButton btnMore = new JButton("More");
		btnMore.setBounds(227, 220, 68, 29);
		panel.add(btnMore);
		
	}
}
