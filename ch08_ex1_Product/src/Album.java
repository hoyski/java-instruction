
public class Album extends Product {

	// Fields
	private String artist;

	// Constructors
	public Album() {
		super();
		artist = "";
		count++;
	}

	// Getters and setters
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + artist + ")";
	}
}
