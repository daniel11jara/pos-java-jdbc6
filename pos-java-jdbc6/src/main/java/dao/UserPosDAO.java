package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserPosDAO {
	
	private Connection connection;//chamando a conexão
	
	//construtor para quando iniciar esse objeto ele vai colocar para dentro do objeto connection o sigleConnection
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

}
