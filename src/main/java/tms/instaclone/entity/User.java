package tms.instaclone.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User extends Entity implements Comparable<User> {
    private String email;
    private MobilePhoneNumber mobilePhoneNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate birthday;
    private List<Story> stories;
    private List<Publication> savedPublications = new ArrayList<>(0); // INST-24: card-block-save (publication, that user saved, but they're not his own)

    public User() {
    }

    public User(long id, String username) {
        super(id);
        this.username = username;
    }

    public User(String email, MobilePhoneNumber mobilePhoneNumber, String firstName, String lastName, String username,
                String password, LocalDate birthday) {
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthday = birthday;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MobilePhoneNumber getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(MobilePhoneNumber mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Publication> getPublications() {                 // INST-24: card-block-save
        return savedPublications;
    }

    public void setPublications(List<Publication> publications) {        // INST-24: card-block-save
        this.savedPublications = publications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return super.toString() +
                "User{" +
                "email='" + email + '\'' +
                ", mobilePhoneNumber=" + mobilePhoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", stories=" + stories +
                '}' + '}';
    }

    @Override
    public int compareTo(User user) {
        return getUsername().compareTo(user.getUsername());
    }
}
