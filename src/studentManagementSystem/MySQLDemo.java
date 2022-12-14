package studentManagementSystem;
import java.sql.*;
public class MySQLDemo {
	 
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/StudentManagement";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "tyw199639";
    
    public boolean getLoginInfo(String username, String password) throws SQLException {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
        System.out.println("Connecting");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Searching sql");
        String sql;
        sql="Select * from AdminInform where Username= ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet rs=pstmt.executeQuery();
        String pd = "";
        //System.out.println(rs.next());
        if(!rs.next()) return false;
        else{
        	String un=rs.getString("Username");
        	//System.out.println(un);
        	pd=rs.getString("Password");
//        	System.out.println(pd);
//        	System.out.println(password);
        }
        //System.out.print(pd);
        rs.close();
        pstmt.close();
        conn.close();
        return pd.equals(password);
        
    }
    
    public void createStd(String name, String studentID, String birthday, String major, String gender,
			double creditsGained, double totalGrades) throws SQLException {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
        System.out.print("Connecting");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.print("Searching sql");
        String sql;
        sql="INSERT StudentManagement.StudentInfo(StudentName,StudentID,Birthday,Major,Gender,Credits,Grades)"
      		+ "VALUES(?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, studentID);
        pstmt.setString(3, birthday);
        pstmt.setString(4, major);
        pstmt.setString(5, gender);
        pstmt.setDouble(6,creditsGained);
        pstmt.setDouble(7, totalGrades);
        int rs = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        System.out.print(rs);
    }
    public void updateStd(String name, String studentID, String birthday, String major, String gender,
			double creditsGained, double totalGrades) throws SQLException {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
        System.out.print("Connecting");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.print("Searching sql");
        String sql;
      sql="Update StudentManagement.StudentInfo SET StudentName=?,StudentID=?,Birthday=?,Major=?,Gender=?,Credits=?,Grades=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, studentID);
      pstmt.setString(3, birthday);
      pstmt.setString(4, major);
      pstmt.setString(5, gender);
      pstmt.setDouble(6,creditsGained);
      pstmt.setDouble(7, totalGrades);
      int rs = pstmt.executeUpdate();
      	pstmt.close();
        conn.close();
        System.out.print(rs);
    }
    public String[] search(String studentNameID) throws SQLException {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
        System.out.print("Connecting");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.print("Searching sql");
        String sql;
        sql="SELECT * FROM StudentInfo WHERE StudentName=? AND StudentID=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,studentNameID);
        pstmt.setString(2,studentNameID);
        ResultSet rs=pstmt.executeQuery();
        String[] res=new String[7];
        //System.out.print(rs.next());
        if(!rs.next()) return res;
        else {
        	res[0]=rs.getString("StudentName");
        	//System.out.println(res[0]);
        	res[1]=rs.getString("StudentID");
        	//System.out.println(res[1]);
        	res[2]=rs.getString("Birthday");
        	res[3]=rs.getString("Major");
        	res[4]=rs.getString("Gender");
        	res[5]=Double.toString(rs.getDouble("Credits"));
        	res[6]=Double.toString(rs.getDouble("Grades"));
        	
        
        }
        rs.close();
        pstmt.close();
        conn.close();
        return res;
    }
    
   public boolean deleteStd(String stdName,String stdID) throws SQLException {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
       System.out.print("Connecting");
       conn=DriverManager.getConnection(DB_URL,USER,PASS);
       System.out.print("Searching sql");
       String sql;
       sql="DELETE FROM StudentManagement.StudentInfo WHERE StudentName=? AND StudentID=?";
       pstmt = conn.prepareStatement(sql);
       pstmt.setString(1,stdName);
       pstmt.setString(2,stdID);
       int rs=pstmt.executeUpdate();
       pstmt.close();
       conn.close();
       return true;
       
   }
    

    public static void main(String[] args) throws SQLException {
		MySQLDemo action=new MySQLDemo();
		String s="123";
		action.getLoginInfo(s, s);
		System.out.print(action.getLoginInfo(s, s));
}
}

