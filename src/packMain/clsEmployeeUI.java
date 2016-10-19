package packMain;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import packEmployee.clsEmployee;

public class clsEmployeeUI extends JFrame implements interfaceMain {
	
	private static final long serialVersionUID = -483865508050000337L;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;
	protected clsEmployee employeeInfo;
	
	public clsEmployeeUI() 
	{
		setTitle("Enter Employee Info");
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 382, 303);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId.setBounds(28, 43, 142, 28);
		panel.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeName.setBounds(28, 110, 142, 28);
		panel.add(lblEmployeeName);
		
		JLabel lblDate = new JLabel("Date (DD-MM-YYYY):");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(28, 171, 154, 28);
		panel.add(lblDate);
		
		txtId = new JTextField();
		txtId.setBounds(194, 43, 141, 31);
		panel.add(txtId);
		
		txtName = new JTextField();
		txtName.setBounds(194, 110, 141, 31);
		panel.add(txtName);
		
		txtDay = new JTextField();
		txtDay.setBounds(194, 171, 36, 31);
		panel.add(txtDay);
		
		txtMonth = new JTextField();
		txtMonth.setBounds(242, 171, 34, 31);
		panel.add(txtMonth);
		
		txtYear = new JTextField();
		txtYear.setBounds(288, 171, 47, 31);
		panel.add(txtYear);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(138, 236, 115, 31);
		btnDone.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if (clsMain.catchNumberFormatError(txtId, "Please enter a positive integer for the ID.") || 
						clsMain.catchNumberFormatError(txtDay, "Please enter a proper day of this month.") ||
						clsMain.catchNumberFormatError(txtMonth, "Please enter an integer from 1 to 12.") ||
						clsMain.catchNumberFormatError(txtYear, "Please enter a proper year."))
				{
					return;
				}
				
				int ID = Integer.parseInt(txtId.getText());
				String name = txtName.getText();
				int day = Integer.parseInt(txtDay.getText());
				int month = Integer.parseInt(txtMonth.getText());
				int year = Integer.parseInt(txtYear.getText());
				int maxDays;
				
				if (month < 0 || month > 12) {
					JOptionPane.showMessageDialog(null, "Please enter a month, from 1 to 12.", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				switch (month) 
				{
				case 1: maxDays = JAN;
						break;
				case 2: maxDays = FEB;
						if (year % 4 != 0) 
						{
							break;
						} else if (year % 100 != 0)
						{
							maxDays += 1;
							break;
						} else if (year % 400 != 0)
						{
							break;
						} else
						{
							maxDays += 1;
							break;
						}
				case 3: maxDays = MAR;
						break;
				case 4: maxDays = APR;
						break;
				case 5: maxDays = MAY;
						break;
				case 6: maxDays = JUN;
						break;
				case 7: maxDays = JUL;
						break;
				case 8: maxDays = AUG;
						break;
				case 9: maxDays = SEP;
						break;
				case 10: maxDays = OCT;
						break;
				case 11: maxDays = NOV;
						break;
				case 12: maxDays = DEC;
						break;
				default: maxDays = 31;
				}
				
				if (day < 0 || day > maxDays)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid day value for this month.", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				employeeInfo = new clsEmployee(ID, name, new GregorianCalendar(year, month, day));
				clsEmployeeUI.this.dispose();
			}
		});
		panel.add(btnDone);
	}
	
	public static void main(String[] args) 
	{
		clsEmployeeUI frame = new clsEmployeeUI();
		frame.setSize(400, 350);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}