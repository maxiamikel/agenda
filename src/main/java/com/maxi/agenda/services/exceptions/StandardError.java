package com.maxi.agenda.services.exceptions;

public class StandardError {

    private Long moment;
    private Integer status;
    private String message;

    public StandardError(Long moment, Integer status, String message) {
        this.moment = moment;
        this.status = status;
        this.message = message;
    }

    public StandardError() {
        super();
    }

    public Long getMoment() {
        return moment;
    }

    public void setMoment(Long moment) {
        this.moment = moment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
