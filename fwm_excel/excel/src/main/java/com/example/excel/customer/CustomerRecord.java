package com.example.excel.customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerRecord {

    private Long id;
    private LocalDate recordDate;
    private String name;
    private String phone;
    private Integer age;
    private String projectContent;
    private String operator;
    private String injectionDoctor;
    private String injectionReceptionist;
    private BigDecimal totalAmount;
    private BigDecimal doctorFee;
    private BigDecimal nurseFee;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInjectionDoctor() {
        return injectionDoctor;
    }

    public void setInjectionDoctor(String injectionDoctor) {
        this.injectionDoctor = injectionDoctor;
    }

    public String getInjectionReceptionist() {
        return injectionReceptionist;
    }

    public void setInjectionReceptionist(String injectionReceptionist) {
        this.injectionReceptionist = injectionReceptionist;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(BigDecimal doctorFee) {
        this.doctorFee = doctorFee;
    }

    public BigDecimal getNurseFee() {
        return nurseFee;
    }

    public void setNurseFee(BigDecimal nurseFee) {
        this.nurseFee = nurseFee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
