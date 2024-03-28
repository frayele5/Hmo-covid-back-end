package com.example.hmo;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class CovidInformation {
    private Date[] vaccineDates;
    private String[] vaccineManufacturers;
    private Date positiveResultDate;
    private Date recoveryDate;

    public CovidInformation() {
        this.vaccineDates = new Date[4];
        this.vaccineManufacturers = new String[4];
    }
}
