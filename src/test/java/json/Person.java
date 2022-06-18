package json;

public class Person {

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public IdentificationDocumentDetails getIdentificationDocumentDetails() {
        return identificationDocumentDetails;
    }

    public void setIdentificationDocumentDetails(IdentificationDocumentDetails identificationDocumentDetails) {
        this.identificationDocumentDetails = identificationDocumentDetails;
    }

    private String motherMaidenName;
    private Name name;
    private Demographics demographics;
    private Email email;
    private IdentificationDocumentDetails identificationDocumentDetails;
    static class Name {
        private String salutation;
        private String givenName;
        private String surname;
        private String middleName;
    }
    static class Demographics {
        private Integer residenceDurationInYears;
        private String dateOfBirth;
        private String countryOfBirth;
        private String gender;
        private String correspondenceLanguageCode;
        private String maritalStatus;
    }
    static class Email {
        private String emailAddress;
        private Boolean isPreferredEmailAddress;
    }
    static class IdentificationDocumentDetails {
        private String idType;
        private String idNumber;
        private String idIssueCountry;
        private Boolean isPrimaryId;
    }

}
