package com.priem.models;

public class Enrollee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Integer faculty;
    private Integer langResult;
    private Integer mathResult;
    private Integer physResult;
    private Integer certificate;
    private Integer certificateType;
    private Integer pointsSum;
    private String dateOfBirth;
    private boolean isApplied;

    public Enrollee(String firstName, String lastName, String email,
                    String address, String dateOfBirth, Integer faculty, Integer langResult,
                    Integer mathResult, Integer physResult, Integer certificate, Integer certificateType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.faculty = faculty;
        this.langResult = langResult;
        this.mathResult = mathResult;
        this.physResult = physResult;
        this.certificate = certificate;
        this.certificateType = certificateType;
    }

    public Enrollee(String firstName, String lastName, String email,
                    String address, String dateOfBirth, boolean isApplied) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.isApplied = isApplied;
    }

    public Enrollee(String firstName, String lastName, Integer langResult, Integer mathResult, Integer physResult, Integer certificate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pointsSum = langResult + mathResult + physResult + certificate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public Integer getLangResult() {
        return langResult;
    }

    public void setLangResult(Integer langResult) {
        this.langResult = langResult;
    }

    public Integer getMathResult() {
        return mathResult;
    }

    public void setMathResult(Integer mathResult) {
        this.mathResult = mathResult;
    }

    public Integer getPhysResult() {
        return physResult;
    }

    public void setPhysResult(Integer physResult) {
        this.physResult = physResult;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isApplied() { return isApplied; }

    public void setApplied(boolean applied) { isApplied = applied; }

    public Integer getPointsSum() { return pointsSum; }

    public void setPointsSum(Integer pointsSum) { this.pointsSum = pointsSum; }
}
