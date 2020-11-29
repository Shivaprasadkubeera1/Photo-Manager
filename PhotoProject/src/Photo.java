import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.mysql.jdbc.Driver;

public class Photo {

	String name;

	public Photo() {

	}
	public Photo(String name) {
		this.name = name;
	}

	public String getPath() {
		return name;
	}

	@Override
	public String toString() {
		return "Photo [name=" + name + "]";
	}

	public void addPhoto(String name) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/photomanager", "root", "root123");
		String sql = "INSERT INTO `photomanager`.`photolist` (`name`) VALUES (?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, name);
		int i = prepareStatement.executeUpdate();
		System.out.println(i+" Photo added successfully..");
	}

	public void deletePhoto(String name) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/photomanager", "root", "root123");
		String sql = "DELETE FROM `photomanager`.`photolist` WHERE (`name` = ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, name);
		int i = prepareStatement.executeUpdate();
		System.out.println(i+" Photo deleted successfully..");	}

	public String display() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/photomanager", "root", "root123");
		String sql = "SELECT * FROM photomanager.photolist";
		Statement createStatement = connection.createStatement();
		System.out.println("PHOTO-LIST");
		System.out.println("===========");
		ResultSet resultSet = createStatement.executeQuery(sql);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
			System.out.println("_________");

		}
		return name;
	}
}
