package bmdb.ui;

import java.time.LocalDate;
import java.util.List;

import bmdb.business.Actor;
import bmdb.db.ActorDb;

public class BmdbApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Bootcamp Movie Database!");
		System.out.println();
		System.out.println("COMMANDS");
		System.out.println("la - List Actors");
		System.out.println("aa - Add Actor");
		System.out.println("gabn - Get an actor by last name");
		System.out.println("gabi - Get an actor by ID");
		System.out.println("da - Delete an actor by ID");
		System.out.println("ua - Update actor");
		System.out.println("exit - Exit the application");

		ActorDb actorDb = new ActorDb();

		String command = Console.getString("Enter command: ");
		while (!command.equalsIgnoreCase("exit")) {

			switch (command) {
			case "la":
				List<Actor> actors = actorDb.getAll();
				System.out.println("Actors: ");
				for (Actor actor : actors) {
					System.out.println(actor);
				}
				break;

			case "aa":
				addActor(actorDb);
				break;

			case "gabn":
				String lastName = Console.getString("Actor's last name: ");
				Actor actor = actorDb.getActorByLastName(lastName);
				if (actor == null) {
					System.out.println("No actor found");
				} else {
					System.out.println(actor);
				}
				break;

			case "gabi":
				long id = Console.getInt("Actor's ID: ");
				Actor actorById = actorDb.get(id);
				if (actorById == null) {
					System.out.println("No actor found");
				} else {
					System.out.println(actorById);
				}
				break;

			case "da":
				long idToDel = Console.getInt("Actor ID to delete: ");
				if (actorDb.delete(idToDel)) {
					System.out.println("Actor deleted");
				} else {
					System.out.println("Error deleting actor");
				}
				break;

			case "ua":
				updateActor(actorDb);
				break;
			}

			command = Console.getString("Enter command: ");
		}
	}

	private static void addActor(ActorDb actorDb) {
		String firstName = Console.getString("First name: ");
		String lastName = Console.getString("Last name: ");
		String gender = Console.getString("Gender: ");
		String birthDateStr = Console.getString("Birthdate (YYYY-MM-DD): ");
		LocalDate birthDate = LocalDate.parse(birthDateStr);

		Actor actor = new Actor(0, firstName, lastName, gender, birthDate);

		if (actorDb.add(actor)) {
			System.out.println("Actor added successfully");
		} else {
			System.out.println("Error adding actor");
		}
	}

	private static void updateActor(ActorDb actorDb) {
		long updId = Console.getInt("ID: ");
		String updFirstName = Console.getString("First name: ");
		String updLastName = Console.getString("Last name: ");
		String updGender = Console.getString("Gender: ");
		String updBirthDateStr = Console.getString("Birthdate (YYYY-MM-DD): ");
		LocalDate updBirthDate = LocalDate.parse(updBirthDateStr);

		Actor updActor = new Actor(updId, updFirstName, updLastName, updGender, updBirthDate);

		if (actorDb.update(updActor)) {
			System.out.println("Actor updated successfully");
		} else {
			System.out.println("Error updating actor");
		}
	}

}
