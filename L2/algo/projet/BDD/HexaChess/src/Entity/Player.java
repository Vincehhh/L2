package src.Entity;

public class Player  {
	private String playerId;
	private String handle;
	private String email;
	private int rating;
	
	
	public Player(String playerId, String handle, String email, int rating) {
		this.playerId= playerId;
		this.handle=handle;
		this.email = email;
		this.rating = rating;
	}


	public String getPlayerId() {
		return playerId;
	}


	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}


	public String getHandle() {
		return handle;
	}


	public void setHandle(String handle) {
		this.handle = handle;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

}
