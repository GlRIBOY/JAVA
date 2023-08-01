package co.yedam.hr;

import java.util.List;

public class JdbcExe {

	public static void main(String[] args) {

		EmpVO emp = new EmpVO();

		EmpDAO dao = new EmpDAO();
		dao.delEmp(1001);

		System.out.println("end of prog");
	}

}
