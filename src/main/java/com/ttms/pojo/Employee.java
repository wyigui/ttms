package com.ttms.pojo;

public class Employee {
    private Integer id;

    private String empNo;

    private String empName;

    private String empTelNum;

    private String empAddr;

    private String empEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpTelNum() {
        return empTelNum;
    }

    public void setEmpTelNum(String empTelNum) {
        this.empTelNum = empTelNum == null ? null : empTelNum.trim();
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr == null ? null : empAddr.trim();
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail == null ? null : empEmail.trim();
    }
}