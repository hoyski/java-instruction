public class Book extends Product {

	private String author;

	public Book() {
		super();
		author = "";
		count++;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		System.err.println("In Book's toString()");
		return super.toString() + " by " + author;
	}
}
