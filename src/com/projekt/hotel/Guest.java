package com.projekt.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {

    private boolean commercialGuest;
    private String companyName;
    private int companyVatNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;

    public Guest(boolean commercialGuest, String companyName, int companyVatNumber, String firstName, String lastName,
                 LocalDate dateBirth) {
        this.commercialGuest = commercialGuest;
        this.companyName = companyName;
        this.companyVatNumber = companyVatNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
    }
    public boolean getCommercialGuest() {return commercialGuest;}
    public String getCompanyName() {return companyName;}
    public int getCompanyVatNumber() {return companyVatNumber;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getFullName() {
        if (commercialGuest == false) {return firstName + " " + lastName;}
        else {return firstName + lastName;}
    }
    public String getDateBirth() {
        if (commercialGuest == false) {return dateBirth.format(DateTimeFormatter.ofPattern("d.M.yyyy"));} else {return "";}
    }
    public String getFullNameAndDateBirth() {
        if (getLastName() != "zatím neznámý") {
            return getFullName() + " *" + dateBirth.format(DateTimeFormatter.ofPattern("d.M.yyyy"));}
        else {return "zatím neznámý";}
    }
    public String getCompanyNameAndCompanyVatNumber() {
        if (commercialGuest == true) {return companyName + ", IČO: " + companyVatNumber;} else {return "";}
    }

}
