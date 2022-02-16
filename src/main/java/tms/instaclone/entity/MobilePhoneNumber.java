package tms.instaclone.entity;

import java.util.Objects;

public class MobilePhoneNumber extends Entity {
    private String countryCallingCode;
    private String phoneNumber;

    public MobilePhoneNumber(String countryCallingCode, String phoneNumber) {
        this.countryCallingCode = countryCallingCode;
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    public void setCountryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhoneNumber that = (MobilePhoneNumber) o;
        return countryCallingCode.equals(that.countryCallingCode) && phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCallingCode, phoneNumber);
    }

    @Override
    public String toString() {
        return "MobilePhoneNumber{" +
                "countryCallingCode='" + countryCallingCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}' + '}';
    }
}
