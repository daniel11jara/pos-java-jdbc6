package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5433/posjava6";
	private static String password = "admin";//senha definida na instalação
	private static String user = "postgres";
	private static Connection connection = null;
	
	//sempre de qualquer lugar que evocar o singleConnection ele vai chamar o conectar
	static {
		conectar();
	}
	
	public SingleConnection() {//construtor
		conectar();//chamando o metodo conectar
	}
	
	private static void conectar() {// metodo que faz a conexao
		
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");//carregando o driver do postgre
				connection = DriverManager.getConnection(url, user, password);//objeto conexao é atribuido o driver passando os parametros
				connection.setAutoCommit(false);//para não salvar automaticamente
				
				System.out.println("Conectou com sucesso");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//public - porque tem que ficar acessivel para outras classes
	public static Connection getConnection() {// vai retornar a conexão
		return connection;
	}

}
