package dao;

import java.sql.Connection;

public class App {

	public static void main(String[] args) {
		System.out.println(Dao.statusConexao());
		Connection conexao = Dao.getConexao();
		System.out.println(Dao.statusConexao());
	}

}
