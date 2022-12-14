package studentManagementSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditFrame {
	private JTextField nameInput=new JTextField(18);
	private JTextField stdIDInput=new JTextField(18);
	private JTextField bthdInput=new JTextField("mm/dd/yyyy",18);
	private JTextField gdInput=new JTextField(18);
	private JTextField mjInput=new JTextField(18);
	private JTextField credits=new  JTextField(18);
	private JTextField grades=new  JTextField(18);
	public JTextField getCredits() {
		return credits;
	}
	public void setCredits(JTextField credits) {
		this.credits = credits;
	}
	public JTextField getGrades() {
		return grades;
	}
	public void setGrades(JTextField grades) {
		this.grades = grades;
	}
	public JTextField getNameInput() {
		return nameInput;
	}
	public void setNameInput(JTextField nameInput) {
		this.nameInput = nameInput;
	}
	public JTextField getStdIDInput() {
		return stdIDInput;
	}
	public void setStdIDInput(JTextField stdIDInput) {
		this.stdIDInput = stdIDInput;
	}
	public JTextField getBthdInput() {
		return bthdInput;
	}
	public void setBthdInput(JTextField bthdInput) {
		this.bthdInput = bthdInput;
	}
	public JTextField getGdInput() {
		return gdInput;
	}
	public void setGdInput(JTextField gdInput) {
		this.gdInput = gdInput;
	}
	public JTextField getMjInput() {
		return mjInput;
	}
	public void setMjInput(JTextField mjInput) {
		this.mjInput = mjInput;
	}
	public void edit() {
		editPage();
	}
	private void editPage() {
		JFrame frame = new JFrame();
		frame.setTitle("Update Student Information");// 设置窗体的标题
		frame.setSize(300, 650);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frame.setResizable(true);// 设置禁止调整窗体大小
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 10);
		frame.setLayout(fl);
		Dimension dim2 = new Dimension(200,100);
		JLabel stdName= new JLabel("Student Name");
		stdName.setSize(dim2);
		frame.add(stdName);
		
		
		nameInput.setSize(dim2);
		JLabel stdID= new JLabel("Student ID");
		stdID.setSize(dim2);;
		
		stdIDInput.setSize(dim2);
		JLabel Birthday= new JLabel("Date of Birth");
		
		bthdInput.setSize(dim2);
		JLabel gender =new JLabel("Gender");
		
		gdInput.setSize(dim2);
		JLabel major= new JLabel("Major");
		JLabel creditsL= new JLabel("Credits");
		JLabel gradesL= new JLabel("Grades");
//		JLabel Grades =new JLabel("Grades");
//		JTextField gdInput=new JTextField("Grades");
		JButton submit=new JButton("Submit");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					addActionListener(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton delete=new JButton("Delete Student");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					addActionListener1(e);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		frame.add(nameInput);
		frame.add(mjInput);
		frame.add(stdID);
		frame.add(stdIDInput);
		frame.add(Birthday);
		frame.add(bthdInput);
		frame.add(gender);
		frame.add(gdInput);
		frame.add(major);
		frame.add(mjInput);
		frame.add(creditsL);
		frame.add(credits);
		frame.add(gradesL);
		frame.add(grades);
		frame.add(submit);
		frame.add(delete);
		frame.setVisible(true);// 设置窗体为可见
		
		
	}
	
	void addActionListener(ActionEvent evt) throws IOException {
		String name=nameInput.getText();
		String studentID=stdIDInput.getText();
		String birthday=bthdInput.getText();
		String major=mjInput.getText();
		String gender=gdInput.getText();
		double creditsGained=0;
		double totalGrades=0;
		MySQLDemo changeInfo=new MySQLDemo();
		try {
			changeInfo.updateStd(name, studentID, birthday, major, gender, creditsGained, totalGrades);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Change has been saved!");
		
			
	}
	void addActionListener1(ActionEvent e) throws IOException, SQLException {
		String name=nameInput.getText();
		String studentID=stdIDInput.getText();
		MySQLDemo deleteInfo=new MySQLDemo();
		deleteInfo.deleteStd(name, studentID);
		JOptionPane.showMessageDialog(null, "Student has been removed!");
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EditFrame().edit();
	}

}
