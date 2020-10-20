import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class CustomerTextFile implements DAO<Customer> {

	private List<Customer> customers = null;
	private Path customersPath = null;
	private File customersFile = null;

	private final String FIELD_SEP = "\t";

	public CustomerTextFile() throws IOException {
		customersPath = Paths.get("customers.txt");
		customersFile = customersPath.toFile();

		// Read the customers from the file
		getAll();
	}

	@Override
	public List<Customer> getAll() throws IOException {
		// if the customers file has already been read, don't read it again
		if (customers != null) {
			return customers;
		}

		customers = new ArrayList<>();

		// load the array list with Customer objects created from
		// the data in the file
		try (BufferedReader in = new BufferedReader(new FileReader(customersFile))) {

			String line = in.readLine();

			while (line != null) {
				String[] fields = line.split(FIELD_SEP);
				Customer cust = new Customer(fields[0], fields[1], fields[2]);
				customers.add(cust);

				line = in.readLine();
			}

		}

		return customers;
	}

	@Override
	public Customer get(String email) throws IOException, NoSuchCustomerException {
		for (Customer c : customers) {
			if (c.getEmail().equals(email)) {
				return c;
			}
		}

		throw new NoSuchCustomerException("Customer with email " + email + " not found");
	}

	@Override
	public boolean add(Customer c) throws IOException {
		customers.add(c);
		return this.saveAll();
	}

	@Override
	public boolean delete(Customer c) throws IOException {
		customers.remove(c);
		return this.saveAll();
	}

	@Override
	public boolean update(Customer newCustomer) throws IOException {
		// get the old customer and remove it
		try {
			Customer oldCustomer = this.get(newCustomer.getEmail());
			int i = customers.indexOf(oldCustomer);
			customers.remove(i);

			// add the updated customer
			customers.add(i, newCustomer);
		} catch (NoSuchCustomerException ignored) {
			return false;
		}

		return this.saveAll();
	}

	private boolean saveAll() {
		// save the Customer objects in the array list to the file
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(customersFile)))) {

			for (Customer c : customers) {
				out.print(c.getFirstName());
				out.print(FIELD_SEP);
				out.print(c.getLastName());
				out.print(FIELD_SEP);
				out.println(c.getEmail());
			}

		} catch (IOException e) {
			System.out.println(e);
			return false;
		}

		return true;
	}
}