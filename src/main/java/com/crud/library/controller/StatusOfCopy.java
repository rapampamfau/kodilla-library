package com.crud.library.controller;

public enum StatusOfCopy {
    HIRED("HIRED"), AVAILABLE("AVAILABLE");

    String status;

    StatusOfCopy(String status) {
        this.status = status;
    }
}
