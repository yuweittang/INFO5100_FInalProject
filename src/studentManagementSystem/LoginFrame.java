package studentManagementSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame {
	private JButton Login=new JButton("Login");
	private JTextField textName = new JTextField();
	private JTextField textword=new JTextField();
	public void login() {
		initUI();
	}
	public void initUI() {
		JFrame frame = new JFrame();
		frame.setTitle("Login");// 设置窗体的标题
		frame.setSize(400, 650);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frame.setResizable(false);// 设置禁止调整窗体大小
 
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// 实例化流式布局类的对象
		frame.setLayout(fl);
		
		// 实例化JLabel标签对象，该对象显示"账号："
		JLabel labName = new JLabel("Username：");
		// 将labName标签添加到窗体上
		frame.add(labName);
 
		// 实例化JTextField标签对象
		
		Dimension dim1 = new Dimension(300,30);
		//textName.setSize(dim);//setSize这方法只对顶级容器有效，其他组件使用无效。
		textName.setPreferredSize(dim1);//设置除顶级容器组件其他组件的大小
		// 将textName标签添加到窗体上
		frame.add(textName);
 
		JLabel labpass= new JLabel("Password：");
		frame.add(labpass);
		
		
		
		textword.setPreferredSize(dim1);
		frame.add(textword);
		
		//实例化JButton组件 
		Login=new JButton();
		//设置按钮的显示内容
		Dimension dim2 = new Dimension(100,30);
		Login.setText("Login");
		Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	addActionListener(evt);
            }});
		//设置按钮的大小
		Login.setSize(dim2);
		frame.add(Login);
		
		frame.setVisible(true);// 设置窗体为可见
	}
	@SuppressWarnings("deprecation")
	void addActionListener(java.awt.event.ActionEvent evt) {
		Login lg=new Login(textName.getText(),textword.getText());
		try {
			if(lg.login()) {
				MainFrame menu=new MainFrame();
				menu.menuPage();
				
			}else{
				JOptionPane.showMessageDialog(null, "The username or password is incorrect");
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginFrame().login();
	}

}
