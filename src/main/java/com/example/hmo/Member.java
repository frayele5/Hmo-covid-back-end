package com.example.hmo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private long identityCard;
    private String address;
    private Date birthDate;
    private long phone;
    private long cellPhone;
    private CovidInformation covidInformation;
}


