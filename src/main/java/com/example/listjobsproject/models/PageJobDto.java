package com.example.listjobsproject.models;

import java.math.BigDecimal;

public class PageJobDto {

    private String title;
    private String url;
    private BigDecimal salary;
    private String company;

    public PageJobDto(String title, String url, BigDecimal salary) {
        this.title = title;
        this.url = url;
        this.salary = salary;
    }

    public PageJobDto(String title, String url, BigDecimal salary, String company) {
        this.title = title;
        this.url = url;
        this.salary = salary;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "PageScrapper{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }


    //KLASA BUILDER!!
    public static class PageScrapperBuilder
    {
        private String title;
        private String url;
        private BigDecimal salary;
        private String company;


        public PageScrapperBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PageScrapperBuilder url(String url) {
            this.url = url;
            return this;
        }

        public PageScrapperBuilder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public PageScrapperBuilder company(String company) {
            this.company = company;
            return this;
        }

        public PageJobDto build(){
            return new PageJobDto(title,url,salary,company);
        }
    }











}
