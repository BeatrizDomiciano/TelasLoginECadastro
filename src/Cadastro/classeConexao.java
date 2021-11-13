package Cadastro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



 public class classeConexao {
	
	private static String timezone =  "zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; 
	private static String mydatabase ="usuarios";      
	private static String url = "jdbc:mysql://localhost/" + mydatabase +"?" + timezone; 
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";              
    private static String password = "";      
	
    public static  Connection getConnection() {
    	try {
    		Class.forName(driver);
    		return	DriverManager.getConnection(url,username,password);
    		
    	}catch(ClassNotFoundException | SQLException e) {
    		throw new RuntimeException("Erro Na conexão com o banco de dados");
    		
    	}
    }
    
    public static void closeConnection(Connection con) {
    	try {
    		if (con != null) {
    			con.close();
    		}
    		
    	} catch (SQLException e) {
    		throw new RuntimeException ("Erro ao fechar a coneão com o Banco de Dados");
    	}
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {
    	closeConnection(con);
    	try {
    		if (stmt != null) {
    			stmt.close();
    		}
    		
    	} catch (SQLException e) {
    		throw new RuntimeException ("Erro ao fechar a coneão com o Banco de Dados");
    	}
    	
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
    	closeConnection(con,stmt);
    	try {
    		if (rs != null) {
    			rs.close();
    		}
    		
    	} catch (SQLException e) {
    		throw new RuntimeException ("Erro ao fechar a conexão com o Banco de Dados");
    	}
    	
    }
    
 
 }