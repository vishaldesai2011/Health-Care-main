package com.example.healthcare;

public class SaveAppoinment {

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public SaveAppoinment(String patientName, String hospital, String speciality, String doctor, String date, String phone) {
        PatientName = patientName;
        Hospital = hospital;
        Speciality = speciality;
        Doctor = doctor;
        Date = date;
        Phone = phone;
    }

    String PatientName,Hospital,Speciality,Doctor,Date,Phone;
}
