package tms.instaclone.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class MobilePhoneNumber extends Entity {
    private String countryCallingCode;
    private String phoneNumber;

    public MobilePhoneNumber(String countryCallingCode, String phoneNumber) {
        this.countryCallingCode = countryCallingCode;
        this.phoneNumber = phoneNumber;
    }

    public static Optional<MobilePhoneNumber> getMobilePhoneNumberByLongNumber(String longNumber){
        String onlynumber = longNumber.replaceAll("[\\s\\-\\(\\)]+", "");
        Properties properties = new Properties();
        try(InputStream inputStream = MobilePhoneNumber.class.getClassLoader().getResourceAsStream("countrycallingcode.properties"))
        {
            properties.load(inputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Optional optional = properties.values()
                .stream()
                .filter(x->onlynumber.startsWith(x.toString()
                        .replaceAll(" ", ""))).findFirst();
        if(optional.isPresent()){
            String countryCode = optional.get().toString().replaceAll(" ","");
            String number = onlynumber.substring(countryCode.length(), onlynumber.length());
            MobilePhoneNumber mobilePhoneNumber = new MobilePhoneNumber(countryCode,number);
            return Optional.of(mobilePhoneNumber);
        }else return Optional.empty();

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
        return super.toString() +
                "MobilePhoneNumber{" +
                "countryCallingCode='" + countryCallingCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}' + '}';
    }

}
