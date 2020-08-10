package com.example.a8androidpetukhova_diploma.Key;

public interface Keystore {

    boolean hasPin();

    boolean checkPin(String pin);

    void saveNew(String pin);

}