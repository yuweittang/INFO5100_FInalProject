package studentManagementSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame {
//	private JButton addNew,update,submit;
	private JButton query=new JButton("Student Information Query");
	private JButton addNew=new JButton("Add New Student");
	public void menuPage() {
		mainPage();
		}
	private void mainPage() {
		JFrame frame = new JFrame();
		frame.setTitle("Menu");// 设置窗体的标题
		frame.setSize(400, 450);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frame.setResizable(true);// 设置禁止调整窗体大小
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
		frame.setLayout(fl);
		Dimension dim2 = new Dimension(200,100);
//		JButton query=new JButton("Student Information Query");
//		JButton addNew=new JButton("Add New Student");
		addNew.setSize(dim2);
		addNew.addActionListener(new ActionListener() {
		     public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	addActionLisener1(evt);}
		});
		query.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				addActionLisener2(e);
				
			}
		});
		frame.add(addNew);
//		JButton update=new JButton("Student Information Update");
		query.setSize(dim2);
		frame.add(query);
		frame.setVisible(true);
		
	}
	void addActionLisener1(ActionEvent e) {
		new StudentAccount().stdAccount();
	}
	void addActionLisener2(ActionEvent e) {
		new Search().searchStd();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame menu=new MainFrame();
		menu.menuPage();
	}
	}
