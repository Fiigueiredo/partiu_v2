package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Reserva;

public class ReservaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Reserva reserva) {

		String sql = "INSERT INTO reservas(dataReserva, idCliente, idDestino, quantReservada, precoTotal,"
				+ "statusPedido, pagamento) VALUES(?,?,?,?,?,?,?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(reserva.getDataReserva().getTime()));
			pstm.setInt(2, reserva.getIdCliente());
			pstm.setInt(3, reserva.getIdDestino());
			pstm.setInt(4, reserva.getQuantReservada());
			pstm.setFloat(5, reserva.getPrecoTotal());
			pstm.setString(6, reserva.getStatusPedido());
			pstm.setString(7, reserva.getPagamento());

			pstm.execute();
			System.out.println("Reserva salva com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Reserva> getPedidos() {
		String sql = "SELECT * FROM reservas";

		List<Reserva> pedidos = new ArrayList<Reserva>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva pedido = new Reserva();
				pedido.setIdReserva(rset.getInt("idReserva"));
				pedido.setDataReserva(rset.getDate("dataReserva"));
				pedido.setIdCliente(rset.getInt("idCliente"));
				pedido.setIdDestino(rset.getInt("idDestino"));
				pedido.setQuantReservada(rset.getInt("quantReservada"));
				pedido.setPrecoTotal(rset.getFloat("precoTotal"));
				pedido.setStatusPedido(rset.getString("statusPedido"));
				pedido.setPagamento(rset.getString("pagamento"));

				pedidos.add(pedido);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pedidos;
	}

	public void update(Reserva pedido) {

		String sql = "UPDATE reservas SET precoTotal = ?, pagamento = ?, statusPedido = ?, "
				+ "quantReservada = ? WHERE idReserva = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setFloat(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			pstm.setString(3, pedido.getStatusPedido());
			pstm.setInt(4, pedido.getQuantReservada());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(5, pedido.getIdReserva());

			pstm.execute();
			System.out.println("RESERVA atualizado com sucesso!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM reservas WHERE idReserva = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
			System.out.println("Pedido excluído com sucesso!");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public Reserva getPedidoById(int id) {

		String sql = "SELECT * FROM reservas where idReserva = ?";
		Reserva reserva = new Reserva();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			reserva.setIdReserva(rset.getInt("idReserva"));
			reserva.setIdCliente(rset.getInt("idCliente"));
			reserva.setIdDestino(rset.getInt("idDestino"));
			reserva.setQuantReservada(rset.getInt("quantReservada"));
			reserva.setDataReserva(rset.getDate("DataReserva"));
			reserva.setPrecoTotal(rset.getFloat("precoTotal"));
			reserva.setPagamento(rset.getString("pagamento"));
			reserva.setStatusPedido(rset.getString("statusPedido"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reserva;

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