public class PersonalData {
    private String firstName;
    private String secondName;
    private String patronymicName;

    public PersonalData(String firstName, String secondName, String patronymicName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
    }

    public void deleteSpecialSymbols() {
        firstName = firstName.replaceAll("[^a-zA-Z0-9]", "");
        secondName = secondName.replaceAll("[^a-zA-Z0-9]", "");
        patronymicName = patronymicName.replaceAll("[^a-zA-Z0-9]", "");
    }

    public void convertToLowerCase() {
        firstName = firstName.toLowerCase();
        secondName = secondName.toLowerCase();
        patronymicName = patronymicName.toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + patronymicName;
    }
}
