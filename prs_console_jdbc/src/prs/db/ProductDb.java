package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.exception.PrsDataException;

public class ProductDb {

	public ProductDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<Product> getAll() {
		String selectAll = "SELECT * FROM Product";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {
			List<Product> products = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int vendorId = rs.getInt("VendorId");
				String partNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				String unit = rs.getString("Unit");
				String photoPath = rs.getString("PhotoPath");

				Product product = new Product(id, vendorId, partNumber, name, price, unit, photoPath);

				products.add(product);
			}

			return products;

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products. Msg: " + e.getMessage());
		}
	}

	/**
	 * Adds the given Product to the database
	 * 
	 * @param product The Product to add
	 * @return true if the product is successfully added. Otherwise, false
	 * @throws PrsDataException When there's an error communicating with the
	 *                          database
	 */
	public boolean add(Product product) {
		String insertSql = "INSERT INTO Product(VendorID, PartNumber, Name, Price, Unit, PhotoPath) VALUES(?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(insertSql)) {
			ps.setInt(1, product.getVendorId());
			ps.setString(2, product.getPartNumber());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getUnit());
			ps.setString(6, product.getPhotoPath());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products. Msg: " + e.getMessage());
		}
	}

}
