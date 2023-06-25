package model;

public class Userposjava6 {
	
	//classe que pegou as colunas da tabela e transformou em objeto
	private Long id;
	private String nome;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//to string feito para o for do metodo initListar percorrer a lista de objetos
	@Override
	public String toString() {
		return "Userposjava6 [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	
	

}
