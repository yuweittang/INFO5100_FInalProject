package studentManagementSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentAccount {
	private JTextField nameInput=new JTextField(18);
	private JTextField stdIDInput=new JTextField(18);
	private JTextField bthdInput=new JTextField("mm/dd/yyyy",18);
	private JTextField gdInput=new JTextField(18);
	private JTextField mjInput=new JTextField(18);
	public void stdAccount() {
		studentAcct();
	}
	private void studentAcct() {
		JFrame frame = new JFrame();
		frame.setTitle("Create a student account");// 设置窗体的标题
		frame.setSize(300, 650);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
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
		
//		JLabel Grades =new JLabel("Grades");
//		JTextField gdInput=new JTextField("Grades");
		JButton submit=new JButton("Submit");
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
		frame.add(submit);
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
		Student std=new Student(name,studentID,birthday,major,gender,creditsGained,totalGrades);
		std.input();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentAccount().stdAccount();
	}

}
