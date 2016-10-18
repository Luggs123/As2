package packMain;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class clsEmployeeUI extends JFrame {
	
	private static final long serialVersionUID = -483865508050000337L;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;
	
	public clsEmployeeUI() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(33, 17, 88, 16);
		panel.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(180, 17, 104, 16);
		panel.add(lblEmployeeName);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(354, 17, 33, 16);
		panel.add(lblDate);
		
		txtId = new JTextField();
		txtId.setBounds(16, 45, 130, 26);
		panel.add(txtId);
//		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(169, 45, 130, 26);
		panel.add(txtName);
//		txtName.setColumns(10);
		
		txtDay = new JTextField();
		txtDay.setText("DD");
		txtDay.setBounds(320, 45, 33, 26);
		panel.add(txtDay);
//		txtDay.setColumns(10);
		
		txtMonth = new JTextField();
		txtMonth.setText("MM");
		txtMonth.setBounds(365, 45, 33, 26);
		panel.add(txtMonth);
//		txtMonth.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setText("YYYY");
		txtYear.setBounds(398, 45, 46, 26);
		panel.add(txtYear);
//		txtYyyy.setColumns(10);
	}
	
	public static void main(String[] args) {
		clsEmployeeUI frame = new clsEmployeeUI();
		frame.setSize(500, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
