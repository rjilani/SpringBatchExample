package com.tek.dto.employee;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Rashid Jilani
 */

public class Employee {

    private String emailAddress;
    private String name;
    private String title;

    public Employee() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("emailAddress", this.emailAddress)
                .append("name", this.name)
                .append("title", this.title)
                .toString();
    }
}
