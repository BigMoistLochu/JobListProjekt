package com.example.listjobsproject.models;

import java.math.BigDecimal;

public class PageScrapper {

    private String title;
    private String url;
    private BigDecimal salary;
    private String companyName;

    public PageScrapper(String title, String url, BigDecimal salary) {
        this.title = title;
        this.url = url;
        this.salary = salary;
    }

    public PageScrapper(String title, String url, BigDecimal salary, String companyName) {
        this.title = title;
        this.url = url;
        this.salary = salary;
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }





}
