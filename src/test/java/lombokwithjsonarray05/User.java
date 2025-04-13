package lombokwithjsonarray05;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	
	private Support support;
	
	
	private List<UserData> data;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class UserData{
		private int id;
		private String email;
		private String firstname;
		private String avatar;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Support{
		private String url;
		private String text;
	}

}
