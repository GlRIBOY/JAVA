package com.physical.management.client.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.physical.management.client.service.ClientService;
import com.physical.management.client.service.ClientVO;
import com.physical.management.common.DataSource;

public class ClientServiceImpl implements ClientService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<ClientVO> clientList() {
		String sql = "SELECT C.*, SUBSTR(P.CLIENT_PHONE, 1, 3)||'-'||SUBSTR(P.CLIENT_PHONE, 4, 4)||'-'||SUBSTR(P.CLIENT_PHONE, 8) AS CLIENT_PHONE "
				    + "FROM CLIENTS C LEFT JOIN PHONE P ON C.CLIENT_ID = P.CLIENT_ID ORDER BY C.CLIENT_ID";
		List<ClientVO> clients = new ArrayList<ClientVO>();
		ClientVO vo;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new ClientVO();
				vo.setClientId(rs.getInt("client_id"));
				vo.setClientCategory(rs.getString("client_category"));
				vo.setClientName(rs.getString("client_name"));
				vo.setClientAge(rs.getInt("client_age"));
				vo.setClientHeight(rs.getInt("client_height"));
				vo.setClientWeight(rs.getInt("client_weight"));
				vo.setClientPhone(rs.getString("client_phone"));
				clients.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return clients;
	}

	@Override
	public ClientVO clientSelect(ClientVO vo) {
		String sql = "SELECT C.*, SUBSTR(P.CLIENT_PHONE, 1, 3)||'-'||SUBSTR(P.CLIENT_PHONE, 4, 4)||'-'||SUBSTR(P.CLIENT_PHONE, 8) AS CLIENT_PHONE "
				+ "FROM CLIENTS C LEFT JOIN PHONE P ON C.CLIENT_ID = P.CLIENT_ID WHERE C.CLIENT_ID = ?";
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setInt(1, vo.getClientId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setClientId(rs.getInt("client_id"));
				vo.setClientCategory(rs.getString("client_category"));
				vo.setClientName(rs.getString("client_name"));
				vo.setClientAge(rs.getInt("client_age"));
				vo.setClientHeight(rs.getInt("client_height"));
				vo.setClientWeight(rs.getInt("client_weight"));
				vo.setClientPhone(rs.getString("client_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public List<ClientVO> clientSelects(int n) {
		String ca = "";
		String sql = "SELECT C.*, SUBSTR(P.CLIENT_PHONE, 1, 3)||'-'||SUBSTR(P.CLIENT_PHONE, 4, 4)||'-'||SUBSTR(P.CLIENT_PHONE, 8) AS CLIENT_PHONE "
				+ "FROM CLIENTS C LEFT JOIN PHONE P ON C.CLIENT_ID = P.CLIENT_ID WHERE CLIENT_CATEGORY = ? ORDER BY C.CLIENT_ID";
		List<ClientVO> clients = new ArrayList<ClientVO>();
		ClientVO vo;
		switch (n) {
		case 1:
			ca = "　웨이트　";
			break;
		case 2:
			ca = "파워리프팅";
			break;
		case 3:
			ca = "　요　가　";
			break;
		case 4:
			ca = " 크로스핏 ";
			break;
		}
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, ca);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new ClientVO();
				vo.setClientId(rs.getInt("client_id"));
				vo.setClientCategory(rs.getString("client_category"));
				vo.setClientName(rs.getString("client_name"));
				vo.setClientAge(rs.getInt("client_age"));
				vo.setClientHeight(rs.getInt("client_height"));
				vo.setClientWeight(rs.getInt("client_weight"));
				vo.setClientPhone(rs.getString("client_phone"));
				clients.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return clients;
	}

	@Override
	public List<ClientVO> clientSelectName(String name) {
		String sql = "SELECT C.*, SUBSTR(P.CLIENT_PHONE, 1, 3)||'-'||SUBSTR(P.CLIENT_PHONE, 4, 4)||'-'||SUBSTR(P.CLIENT_PHONE, 8) AS CLIENT_PHONE "
				+ "FROM CLIENTS C LEFT JOIN PHONE P ON C.CLIENT_ID = P.CLIENT_ID WHERE CLIENT_NAME = ? ORDER BY C.CLIENT_ID";
		List<ClientVO> clients = new ArrayList<ClientVO>();
		ClientVO vo;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new ClientVO();
				vo.setClientId(rs.getInt("client_id"));
				vo.setClientCategory(rs.getString("client_category"));
				vo.setClientName(rs.getString("client_name"));
				vo.setClientAge(rs.getInt("client_age"));
				vo.setClientHeight(rs.getInt("client_height"));
				vo.setClientWeight(rs.getInt("client_weight"));
				vo.setClientPhone(rs.getString("client_phone"));
				clients.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return clients;
	}

	public int findUnsetId() {
		int c = 1;
		boolean b = false;

		String sql = "SELECT CLIENT_ID FROM CLIENTS WHERE CLIENT_ID = ?";

		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);

			while (!b) {
				String u = "";
				psmt.setInt(1, c);
				rs = psmt.executeQuery();
				if (rs.next()) {
					u = rs.getString("client_id");
				}
				if (!u.equals("")) {
					c++;
				} else {
					b = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return c;
	}

	@Override
	public int clientInsert(ClientVO vo) {
		int n = 0;
		String sql1 = "INSERT INTO CLIENTS VALUES(?,?,UPPER(?),?,?,?)";
		String sql2 = "INSERT INTO PHONE VALUES(?,?)";
		try {
			int count = findUnsetId();
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql1);
			psmt.setInt(1, count);
			psmt.setString(2, vo.getClientCategory());
			psmt.setString(3, vo.getClientName());
			psmt.setInt(4, vo.getClientAge());
			psmt.setInt(5, vo.getClientHeight());
			psmt.setInt(6, vo.getClientWeight());
			n = psmt.executeUpdate();
			
			psmt = connection.prepareStatement(sql2);
			psmt.setInt(1, count);
			psmt.setString(2, vo.getClientPhone());
			n = psmt.executeUpdate();
			System.out.println("고객번호: " + count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int clientDelete(ClientVO vo) {
		int n = 0;
		String sql1 = "DELETE FROM CLIENTS WHERE CLIENT_ID = ?";
		String sql2 = "DELETE FROM PHONE WHERE CLIENT_ID = ?";
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql1);
			psmt.setInt(1, vo.getClientId());
			n = psmt.executeUpdate();
			psmt = connection.prepareStatement(sql2);
			psmt.setInt(1, vo.getClientId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int clientUpdate(ClientVO vo) {
		int n = 0;
		String sql1 = "UPDATE CLIENTS SET CLIENT_CATEGORY = ?, CLIENT_WEIGHT = ? WHERE CLIENT_ID = ?";
		String sql2 = "UPDATE PHONE SET CLIENT_PHONE = ? WHERE CLIENT_ID = ?";
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql1);
			psmt.setString(1, vo.getClientCategory());
			psmt.setInt(2, vo.getClientWeight());
			psmt.setInt(3, vo.getClientId());
			n += psmt.executeUpdate();
			psmt = connection.prepareStatement(sql2);
			psmt.setString(1, vo.getClientPhone());
			psmt.setInt(2, vo.getClientId());
			n += psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
