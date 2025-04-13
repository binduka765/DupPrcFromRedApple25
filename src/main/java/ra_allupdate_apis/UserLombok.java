package ra_allupdate_apis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserLombok {
	
	//all private vars:
	private String name;
	private String email;
	private String gender;
	private String status;		
}
