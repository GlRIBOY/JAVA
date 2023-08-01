package co.yedam.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection conn = null; // DB연결세션
	PreparedStatement psm;
	ResultSet rs;

	void getConn() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Not found OracleDriver");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconn() {

		try {
			if (conn != null) {
				conn.close();
			}
			if (psm != null) {
				psm.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 입력
	boolean addEmp(EmpVO emp) {
		String sql = "insert into emp_temp (emp_id, emp_name, email, address, salary)";
		sql += "values(?, ?, ?, ?, ?)";
		getConn();
		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, emp.getEmpId());
			psm.setString(2, emp.getEmpName());
			psm.setString(3, emp.getEmail());
			psm.setString(4, emp.getAddress());
			psm.setInt(5, emp.getSalary());
			int r = psm.executeUpdate();// 처리된 건수 반환
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;

	}

	// 목록
	List<EmpVO> empList() {
		String sql = "select * from emp_temp order by emp_id";
		getConn();
		List<EmpVO> list = new ArrayList<>();

		try {
			psm = conn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpId(rs.getInt("emp_id"));
				vo.setEmpName(rs.getString("emp_name"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setSalary(rs.getInt("salary"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 수정
	boolean editEmp(EmpVO emp) {
		String sql = "update emp_temp set address=?, email=? where emp_id=?";
		getConn();
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, emp.getAddress());
			psm.setString(2, emp.getEmail());
			psm.setInt(3, emp.getEmpId());
			int r = psm.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 삭제
	boolean delEmp(int empNo) {
		String sql = "delete from emp_temp where emp_id = ?";
		getConn();
		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, empNo);
			int r = psm.executeUpdate();
			if(r==1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconn();
		}
		return false;
	}

	// 단건조회
	EmpVO getEmp(int empNo) {
		String sql = "select * from emp_temp where emp_id=?";
		getConn();
		
		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, empNo);
			rs = psm.executeQuery();
			String[] list = new String[10];
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpId(rs.getInt("emp_id"));
				vo.setEmpName(rs.getString("emp_name"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setSalary(rs.getInt("salary"));

				list[0] += vo;
			}
			System.out.println(list);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return null;

	}
}
