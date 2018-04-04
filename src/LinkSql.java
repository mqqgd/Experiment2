
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;  
import java.sql.DriverManager;   
import java.sql.SQLException;
public class LinkSql {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/mqqgd";   
	private  static final String user = "root";  
	private  static final String password = "root";
	private static ResultSet ret = null;
	private  static final String name = "com.mysql.jdbc.Driver";
    public Connection conn = null;  
    public PreparedStatement pst = null; 
	public  LinkSql() {  
        try {  
            Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(url, user, password);//��ȡ����             
            System.out.println("���ݿ����ӳɹ�");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	
	public void changeMySqlDate(String sql) {
		try {
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
			System.out.println("���յ��޸����ݿ�����"+sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	}
	public ResultSet selectSqlDate(String sql) {
		try {
			System.out.println("���յ���ѯ���ݿ�����"+sql);
			pst=conn.prepareStatement(sql);
			ret = pst.executeQuery();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	public void closeMySql() {
		try {  
            this.conn.close();   
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
	}
    @SuppressWarnings("static-access")
	public void closeChart() {  
        try {    
            this.pst.close();
            this.ret.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    } 
}
