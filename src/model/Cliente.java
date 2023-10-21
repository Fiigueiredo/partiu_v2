package model;

import java.util.Date;

public class Cliente {
	private int id_cliente;
	private Date cadastro;
	private String nome;
	private String sexo;
	private Date nascimento;
	private String documento;
	private String telefone;
	private String email;
	private String senha;
	private boolean cadastrado;
	private boolean logado;

	public Cliente() {
		super();
	}

	public Cliente(int id_cliente, Date cadastro, String nome, String sexo, Date nascimento, String documento,
			String telefone, String email, String senha, boolean cadastrado, boolean logado) {
		super();
		this.id_cliente = id_cliente;
		this.cadastro = cadastro;
		this.nome = nome;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.cadastrado = cadastrado;
		this.logado = logado;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isCadastrado() {
		return cadastrado;
	}

	public void setCadastrado(boolean cadastrado) {
		this.cadastrado = cadastrado;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", cadastro=" + cadastro + ", nome=" + nome + ", sexo=" + sexo
				+ ", nascimento=" + nascimento + ", documento=" + documento + ", telefone=" + telefone + ", email="
				+ email + ", senha=" + senha + ", cadastrado=" + cadastrado + ", logado=" + logado + "]";
	}

}