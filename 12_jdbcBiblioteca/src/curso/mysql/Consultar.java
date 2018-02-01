package curso.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		
//		Statement st = conn.createStatement();
//		
//		ResultSet rs = st.executeQuery("select * from libros");
//		
//		while(rs.next()) {
//			
//			System.out.println("Titulo: "+rs.getString(2));
//			System.out.println("Precio: "+rs.getFloat(4));
//			System.out.println("Fecha: "+rs.getDate(5));
//		
//		}

//		int insertado = st.executeUpdate("insert into libros (titulo,autor,precio,fechapublicacion) "
//				+ "values ('El señor de los anillos','Tolkien',15.0,'1999-02-05')");
//		System.out.println("Insertadas "+insertado+" filas");
		
		
//		PreparedStatement ps = conn.prepareStatement("select * from libros where titulo = ?");
//		
//		ps.setString(1, "El señor de los anillos");
//		
//		ResultSet rs1 = ps.executeQuery();
//		
//		while(rs1.next()) {
//			
//			System.out.println("Titulo: "+rs1.getString(2));
//			System.out.println("Precio: "+rs1.getFloat(4));
//			System.out.println("Fecha: "+rs1.getDate(5));
		
//		}
		
		CallableStatement cs = conn.prepareCall("{call listaLibrosPorAutor(?)}");
		
		cs.setString(1, "Tolkien");
		ResultSet rs2 = cs.executeQuery();
		
		while(rs2.next()) {
			
			System.out.println("Titulo: "+rs2.getString(2));
			System.out.println("Precio: "+rs2.getFloat(4));
			System.out.println("Fecha: "+rs2.getDate(5));
			System.out.println("----------------");
			
		}
	}

}
