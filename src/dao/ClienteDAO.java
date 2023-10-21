package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;

public class ClienteDAO {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;

	public ClienteDAO() {

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void creat(Cliente cliente) {

		String sql = "INSERT INTO cliente(nome, sexo, nascimento, documento, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getSexo());
			pstm.setDate(3, new Date(cliente.getNascimento().getTime()));
			pstm.setString(4, cliente.getDocumento());
			pstm.setString(5, cliente.getTelefone());
			pstm.setString(6, cliente.getEmail());
			pstm.setString(7, cliente.getSenha());
			pstm.executeUpdate();

			System.out.println("\n*** Cliente cadastrado com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public List<Cliente> read() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> Cliente = new ArrayList<Cliente>();

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(result.getInt("id_cliente"));
				cliente.setCadastro(result.getDate("cadastro"));
				cliente.setNome(result.getString("nome"));
				cliente.setSexo(result.getString("sexo"));
				cliente.setNascimento(result.getDate("nascimento"));
				cliente.setDocumento(result.getString("documento"));
				cliente.setTelefone(result.getString("telefone"));
				cliente.setEmail(result.getString("email"));
				cliente.setSenha(result.getString("senha"));
				Cliente.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (result != null) {
					result.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return Cliente;
	}

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET nome = ?, sexo = ?, documento = ?, telefone = ?, nascimento = ?, email = ?, senha = ?"
				+ "WHERE documento = ?";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, cliente.getNome());
			pstm.setString(1, cliente.getSexo());
			pstm.setString(6, cliente.getDocumento());
			pstm.setString(2, cliente.getTelefone());
			pstm.setDate(3, new Date(cliente.getNascimento().getTime()));
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getSenha());
			pstm.executeUpdate();

			System.out.println("\n*** Cliente atualizado com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String documento) {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, documento);
			pstm.executeUpdate();

			System.out.println("\n*** Cliente excluído com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Cliente buscarClientePorEmail(String email) {

		String sql = "SELECT * FROM cliente WHERE email = ?";

		Cliente cliente = new Cliente();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet result = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			result = pstm.executeQuery();

			result.next();

			cliente.setId_cliente(result.getInt("id_cliente"));
			cliente.setNome(result.getString("nome"));
			cliente.setSexo(result.getString("sexo"));
			cliente.setDocumento(result.getString("documento"));
			cliente.setTelefone(result.getString("telefone"));
			cliente.setNascimento(result.getDate("nascimento"));
			cliente.setEmail(result.getString("email"));
			cliente.setSenha(result.getString("senha"));

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (result != null) {
					result.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return cliente;
	}

	public Cliente getClienteByCpf(String cpf) {

		String sql = "SELECT * FROM clientes WHERE cpf = ?";

		Cliente cliente = new Cliente();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet result = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			result = pstm.executeQuery();

			result.next();

			cliente.setId_cliente(result.getInt("id_cliente"));
			cliente.setNome(result.getString("nome"));
			cliente.setSexo(result.getString("sexo"));
			cliente.setDocumento(result.getString("documento"));
			cliente.setTelefone(result.getString("telefone"));
			cliente.setNascimento(result.getDate("nascimento"));
			cliente.setEmail(result.getString("email"));
			cliente.setSenha(result.getString("senha"));

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (result != null) {
					result.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return cliente;
	}

	public void endConnection() {

		try {
			if (pstm != null) {
				pstm.close();
			}

			if (conn != null && !conn.isClosed()) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}