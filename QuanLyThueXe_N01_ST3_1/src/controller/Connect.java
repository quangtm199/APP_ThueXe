
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

// mấy ae nhớ sửa tài khoản , mật khẩu của mình trong sql để chạy nha !
public class Connect {
    public static Connection getConnection(){
         Connection conection =null;
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433; databaseName=quanlyxe";
            String user="sa";
            String pass="123456";
            conection=DriverManager.getConnection(url, user, pass);
            System.out.println("ket noi thanh cong");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conection;
    }
    public static void closeConnection(Connection con){
        if(con!=null){try {
            con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
}}
 
    
    
        public static void main(String[] args){
            System.out.println(getConnection());}
    
    
}

