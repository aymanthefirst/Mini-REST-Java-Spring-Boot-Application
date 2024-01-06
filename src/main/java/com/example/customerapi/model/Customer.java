package com.example.customerapi.model;

public class Customer {
    private String customerRef;
    private String customerName;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String county;
    private String country;
    private String postcode;

    public Customer(String customerRef, String customerName, String addressLine1, String addressLine2, String town, String county, String country, String postcode) {
        this.customerRef = customerRef;
        this.customerName = customerName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }

    // Getters here (e.g., getCustomerRef, getCustomerName, etc.)

    public String getCustomerRef() {
        return customerRef;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getTown() {
        return town;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }



}
