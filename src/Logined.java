import java.sql.ResultSet;
import java.sql.SQLException;

public class Logined {
	LinkSql ls;
	int result;
	public Logined(){
		ls=new LinkSql();
	}
	boolean login(String name,String pass){
		ResultSet rs=ls.selectSqlDate(String.format("select * from user where name='%s'",name));
		try {
			while(rs.next()){
				if(rs.getString("name").equals(name)&&rs.getString("password").equals(pass)){
					result=rs.getInt("lastscore");
					return true;
				}else{
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public int getScore(String name){
		return result;
	}
}

