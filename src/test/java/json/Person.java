package json;

public class Person {

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public Person.name getName() {
        return name;
    }

    public void setName(Person.name name) {
        this.name = name;
    }

    public Person.demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Person.demographics demographics) {
        this.demographics = demographics;
    }

    public Person.email getEmail() {
        return email;
    }

    public void setEmail(Person.email email) {
        this.email = email;
    }

    public Person.identificationDocumentDetails getIdentificationDocumentDetails() {
        return identificationDocumentDetails;
    }

    public void setIdentificationDocumentDetails(Person.identificationDocumentDetails identificationDocumentDetails) {
        this.identificationDocumentDetails = identificationDocumentDetails;
    }

    private String motherMaidenName;
    private name name;
    private demographics demographics;
    private email email;
    private identificationDocumentDetails identificationDocumentDetails;
    static class name {
        private String salutation;
        private String givenName;
        private String surname;
        private String middleName;
    }
    static class demographics {
        private Integer residenceDurationInYears;
        private String dateOfBirth;
        private String countryOfBirth;
        private String gender;
        private String correspondenceLanguageCode;
        private String maritalStatus;
    }
    static class email {
        private String emailAddress;
        private Boolean isPreferredEmailAddress;
    }
    static class identificationDocumentDetails {
        private String idType;
        private String idNumber;
        private String idIssueCountry;
        private Boolean isPrimaryId;
    }

}
