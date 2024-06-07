package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MoviesDTO;

public class MoviesDAO {

	public static MoviesDAO instance;

	public synchronized static MoviesDAO getInstance() {  // sysnchronized(Thread Safe) 이거를 사용하면 한개의 인스턴스를 생성할때 LOCK이 걸림
		if(instance == null) {
			instance = new MoviesDAO();
		}
		return instance;
	}
	private Connection getConnection() throws Exception { 
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	private MoviesDAO() {}


	// 작성
	String sql = "insert into movies values(movies_seq.nextval, ?, ?, ?)";
	public int insert(MoviesDTO dto)throws Exception{
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setTimestamp(3, dto.getWrite_date());
			int result = pstat.executeUpdate();
			return result;
		}

	}

	// 출력
	public ArrayList<MoviesDTO>getList()throws Exception{
		String sql = "select * from movies order by 1";
		ArrayList<MoviesDTO>array = new ArrayList<>();
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				Timestamp write_date = rs.getTimestamp("write_date");
				array.add(new MoviesDTO(id,title,genre,write_date));			
			}return array;

		}
	}



	// 삭제
	public int deleteById(int id)throws Exception{
		String sql = "delete from movies where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	// 중첵
	public boolean tf(int id) throws Exception{
		String sql = "select * from movies where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			try(ResultSet rs = pstat.executeQuery();){
				boolean result = rs.next();
				return result;
			}
		}
	}


	// 수정
	public int updateList(int id,String title,String genre, Timestamp write_date)throws Exception{
		String sql = "update movies set title = ?, genre = ?, write_date=? where id=?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, title);
			pstat.setString(2, genre);
			pstat.setTimestamp(3, write_date);
			pstat.setInt(4, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}

}
