package deserializationra_gorestusers_ra06;







import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Include;

//creating userLombok for gorest.in specific user data
//instead of JsonInclude(Include.NON_NULL) -- JsonInclude(Include) worked
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude()

public class UserL {

	private int id;
	private String name;
	private String email;
	private String gender;
	private String status;

}
