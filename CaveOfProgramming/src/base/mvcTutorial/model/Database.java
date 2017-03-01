package base.mvcTutorial.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
	private static Database instance = new Database();

	private Connection con;

	private Database()
	{

	}

	public static Database getInstance()
	{
		return instance;
	}

	public Connection getConnection()
	{
		return con;
	}

	public void connect()
	{
		if (con != null)
			return;
		String url = "jdbc:oracle:thin:s14782/oracle12@db-oracle:1521:baza";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drivers loaded");
			con = DriverManager.getConnection(url);
			System.out.println("Connected to database");

		} catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	public void disconnect()
	{
		if (con != null)
		{
			try
			{
				con.close();
			} catch (SQLException e)
			{
				System.out.println("Can't close connection");
			}
		}
		con = null;
	}
}
