package pos_java_jdbc6;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava6;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		//SingleConnection.getConnection(); - deletado na aula de insert
		
		UserPosDAO userPosDAO = new UserPosDAO();//instanciando a classe do CRUD
		Userposjava6 userposjava6 = new Userposjava6();//instanciando a classe das colunas da tabela
		
		//passando os dados para tabela aqui tambem
		userposjava6.setId(5L);
		userposjava6.setNome("Marcos");
		userposjava6.setEmail("marcos@gmail.com");
		
		userPosDAO.salvar(userposjava6);
	}
	
	@Test
	public void initListar() {
		//instanciando a classe do CRUD
		UserPosDAO dao = new UserPosDAO();
		
		try {
			List<Userposjava6> list = dao.listar();
			
			//varrendo os objetos
			for (Userposjava6 userposjava6 : list) {
				//imprimindo o objeto
				System.out.println(userposjava6);
				
				//separando os objetos
				System.out.println("-------------------------");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		
		//instanciando a classe do CRUD
		UserPosDAO dao = new UserPosDAO();
		
		try {
			//passando o objeto das colunas
			Userposjava6 userposjava6 = dao.buscar(3L);
			
			//imprimindo o objeto
			System.out.println(userposjava6);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	

}
