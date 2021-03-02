package com.petukhova.flynotes;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DeadlineComparator implements Comparator<ItemData> {
    private final DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

    @Override
    public int compare(final ItemData first, final ItemData second) {
        try {
            if (TextUtils.isEmpty(first.getDeadline()) && !TextUtils.isEmpty(second.getDeadline())) {
                return 1;
            }
            if (TextUtils.isEmpty(first.getDeadline())) {
                return 0;
            }
            if (TextUtils.isEmpty(second.getDeadline())) {
                return -1;
            }
            Date firstDeadline = format.parse(first.getDeadline());
            Objects.requireNonNull(firstDeadline);
            Date secondDeadline = format.parse(second.getDeadline());
            return firstDeadline.compareTo(secondDeadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
