package studentManagementSystem;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search {
	private JTextField searchInput=new JTextField(20);
	private JButton Search=new JButton("Search");
	private JTextArea output=new JTextArea(40,40);
	private JButton edit=new JButton("Edit");
	public void searchStd() {
		search();
	}
	public void search(){
		JFrame frame = new JFrame();
		frame.setSize(300, 650);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frame.setResizable(true);// 设置禁止调整窗体大小
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 10);
		frame.setLayout(fl);
		frame.setTitle("Search Page");// 设置窗体的标题
		frame.setSize(600, 450);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(3);
		JLabel text=new JLabel("Input student ID or name to search!");
		frame.add(text);
		frame.add(searchInput);
		Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					addActionListener(e);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		frame.add(Search);
		frame.add(output);
		frame.setVisible(true);
		
	}
	void addActionListener(ActionEvent e) throws HeadlessException, IOException, SQLException {
		MySQLDemo action=new MySQLDemo();
		String[] temp=action.search(searchInput.getText());
		
		if(temp[0]!=null) {
					EditFrame update=new EditFrame();
					update.setNameInput(new JTextField(temp[0],18));
					update.setStdIDInput(new JTextField(temp[1],18));
					update.setBthdInput(new JTextField(temp[2],18));
					update.setMjInput(new JTextField(temp[3],18));
					update.setGdInput(new JTextField(temp[4],18));
					update.setCredits(new JTextField(temp[5],18));
					update.setGrades(new JTextField(temp[6],18));
//					
//				JLabel name=new JLabel("Student Name"+temp[0]);
//				JLabel ID=new JLabel("Student ID"+temp[1]);
//				JLabel birthday=new JLabel("Birthday"+temp[2]);
//				JLabel major=new JLabel("Major"+temp[3]);
//				JLabel gender=new JLabel("Gender"+temp[4]);
//				JLabel creditsGained=new JLabel("Credits"+temp[5]);
//				JLabel totalGrade=new JLabel("Total Grades"+temp[6]);
//				output.add(name);
//				output.add(birthday);
//				output.add(major);
//				output.add(gender);
//				output.add(creditsGained);
//				output.add(totalGrade);
				update.edit();}
		else {
				JOptionPane.showMessageDialog(null, "No result found");
				
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Search().searchStd();
	}

}
