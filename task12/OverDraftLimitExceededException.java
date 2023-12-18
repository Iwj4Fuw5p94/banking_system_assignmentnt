package com.hexaware.task12;

public class OverDraftLimitExceededException extends Exception {
    public OverDraftLimitExceededException(String message) {
        super(message);
    }
}