package com.petukhova.flynotes.Key;

import android.content.SharedPreferences;

public class SimpleKeystore implements Keystore {

    private static final String PASSWORD_TEXT = "password_text";
    private SharedPreferences sharedPreferences;

    public SimpleKeystore(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public boolean hasPin() {
        return sharedPreferences.contains(PASSWORD_TEXT);
    }

    @Override
    public boolean checkPin(String pin) {
        return pin.equals(sharedPreferences.getString(PASSWORD_TEXT, null));
    }

    @Override
    public void saveNew(String pin) {
        sharedPreferences.edit()
                .putString(PASSWORD_TEXT, pin)
                .apply();
    }
}

