package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava6;

public class UserPosDAO {
	
	private Connection connection;//chamando a conexão
	
	//construtor para quando iniciar esse objeto ele vai colocar para dentro do objeto connection o sigleConnection
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	//aula 10
	public void salvar(Userposjava6 userposjava6) {
		
		try {
			//preparando o sql
			String sql = "insert into userposjava6 (id, nome, email) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);//executando o sql
			
			//inserindo os dados 
			insert.setLong(1, userposjava6.getId());//coluna 1 -- id
			insert.setString(2, userposjava6.getNome());//coluna 2 -- nome
			insert.setString(3, userposjava6.getEmail());//coluna 3 -- email
			
			//jogando para dentro do banco de dados
			insert.execute();
			
			//salvando no banco
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	//aula 11 -- metodo que vai fazer uma lista da classe que tem as colunas da tabela
	public List<Userposjava6> listar() throws Exception{
		//instanciando a lista
		List<Userposjava6> list = new ArrayList<Userposjava6>();
		
		//passando o comando sql
		String sql = "select * from userposjava6";
		
		//classe preparando o sql
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//classe que vai retornar uma lista
		ResultSet resultado = statement.executeQuery();
		
		//enquanto tiver resultado
		while (resultado.next()) {
			//instanciando a classe que tem as colunas 
			Userposjava6 userposjava6 = new Userposjava6();
			
			//passando os dados para o objeto criado acima
			userposjava6.setId(resultado.getLong("id"));
			userposjava6.setNome(resultado.getString("nome"));
			userposjava6.setEmail(resultado.getString("email"));
			
			//adicionado em uma lista
			list.add(userposjava6);
			
		}
		
		//retornando a lista feita
		return list;
		
	}
	
	//aula 11 -- metodo que vai fazer uma busca nas colunas da tabela
	//não retorna uma lista, vai retornar um objeto
		public Userposjava6 buscar(Long id) throws Exception{
			
			//instanciando o objeto
			Userposjava6 retorno = new Userposjava6();
			
			//passando o comando sql que seleciona apenas o id
			String sql = "select * from userposjava6 where id = " + id;
			
			//classe preparando o sql
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//classe que vai retornar uma lista
			ResultSet resultado = statement.executeQuery();
			
			//enquanto tiver resultado
			while (resultado.next()) {
				//aqui não precisa instanciar a classe das colunas
				//Userposjava6 userposjava6 = new Userposjava6();
				
				//passando os dados para o objeto criado acima
				retorno.setId(resultado.getLong("id"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setEmail(resultado.getString("email"));
				
			}
			
			//retornando a lista feita
			return retorno;
			
		}

}
