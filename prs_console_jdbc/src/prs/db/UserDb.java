package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.User;
import prs.exception.PrsDataException;

public class UserDb {

	public UserDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<User> getAll() {
		String selectAll = "SELECT * FROM User";

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {

			List<User> users = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean isReviewer = rs.getBoolean("isReviewer");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User user = new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer,
						isAdmin);

				users.add(user);
			}

			return users;

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving users. Msg: " + e.getMessage());
		}
	}

	/**
	 * Authenticates a User
	 *
	 * @param userName The user's userName
	 * @param password The user's password
	 * @returns The matching User or null if no matching User found
	 */
	public User authenticateUser(String userName, String password) {
		String selectByUserAndPass = "SELECT * FROM user WHERE UserName = ? AND Password = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(selectByUserAndPass);) {
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("ID");
				String userNameFromDb = rs.getString("UserName");
				String passwordFromDb = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean isReviewer = rs.getBoolean("isReviewer");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User user = new User(id, userNameFromDb, passwordFromDb, firstName, lastName, phoneNumber, email,
						isReviewer, isAdmin);

				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new PrsDataException("Error authenticating user. Msg: " + e.getMessage());
		}
	}
}
