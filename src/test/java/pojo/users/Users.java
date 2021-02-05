package pojo.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {




    private String first_name;
    private String last_name;
    private String gender;

    private String dob;
    private String email;
    private String website;
    private String address;
    private String status;
    private String phone;

    private Links links;












//    {
//        "id": "1832",
//            "first_name": "Test",
//            "last_name": "weeee",
//            "gender": "male",
//            "dob": "1954-04-17",
//            "email": "abc@textron.com",
//            "phone": "639.898.8406 x4625",
//            "website": "http://www.jones.biz/",
//            "address": "770 Katrine Lights\nSouth Gilberto, IL 75839-5956",
//            "status": "active",
}
