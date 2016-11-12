package me.srcmaxim.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SSNAndPassport implements Serializable{

    @Column(name = "ssn")
    private int socialSequreNumber;

    @Column(name = "passport")
    private String passportNumber;

    public SSNAndPassport() {
    }

    public SSNAndPassport(int socialSequreNumber, String passportNumber) {
        this.socialSequreNumber = socialSequreNumber;
        this.passportNumber = passportNumber;
    }

    public int getSocialSequreNumber() {
        return socialSequreNumber;
    }

    public void setSocialSequreNumber(int socialSequreNumber) {
        this.socialSequreNumber = socialSequreNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
