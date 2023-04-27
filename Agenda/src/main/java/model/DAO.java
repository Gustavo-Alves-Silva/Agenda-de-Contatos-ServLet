package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/** modulo de conexão**/
	// Parametros de conexão
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "aluno";
	
	private Connection conectar() {
		Connection con = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, numero, email) values (?, ?,?)";
		try {
			
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<JavaBeans> listarContatos(){
		
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		
		try {
			
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(read );
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				contatos.add(new JavaBeans(idcon,nome,fone,email));
				
			}
			
			con.close();
			
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
	}
	}
	

}