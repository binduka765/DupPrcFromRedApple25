package complexresponse_fakeuserapi04;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeUserLombok {
	
	private String email;
	private String username;
	private String password;
	private String phone;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Name{
		private String firstname;
		private String lastname;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Address{
		
		public Address(String string, String string2, int i, String string3, Object geoloc) {
			// TODO Auto-generated constructor stub
		}

		private String city;
		private String street;
		private int number;
		private String zipcode;
		public static Geolocation Geolocation;
		
		@Data
		@NoArgsConstructor
		@AllArgsConstructor
		@Builder
		public static class Geolocation{
			private String lat;
			private String longitude;
		}
		
	};

}
