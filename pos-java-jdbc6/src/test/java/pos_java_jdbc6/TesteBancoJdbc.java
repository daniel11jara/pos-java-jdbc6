package pos_java_jdbc6;

import org.junit.Test;

import conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

	

}
