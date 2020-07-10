package com.example.a8androidpetukhova_diploma;

public interface Keystore {

    boolean hasPin();

    boolean checkPin(String pin);

    void saveNew(String pin);

}