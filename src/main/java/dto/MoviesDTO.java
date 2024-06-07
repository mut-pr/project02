package dto;

import java.sql.Timestamp;

public class MoviesDTO {

	private int id;
	private String title;
	private String genre;
	private Timestamp write_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	public MoviesDTO() {};
	
	public MoviesDTO(int id, String title, String genre, Timestamp write_date) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.write_date = write_date;
	}
	
	
	
	
}
