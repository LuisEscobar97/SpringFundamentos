package com.fundamentos.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String name;
    private LocalDate bithDate;

    public UserDto(Long id, String name, LocalDate bithDate) {
        this.id = id;
        this.name = name;
        this.bithDate = bithDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bithDay='" + bithDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBithDay() {
        return bithDate;
    }

    public void setBithDay(LocalDate bithDay) {
        this.bithDate = bithDay;
    }
}
