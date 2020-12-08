package com.android.javajsonapp;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Dates {
    @SerializedName("maximum")
    private LocalDate maximum;
    @SerializedName("minimum")
    private LocalDate minimum;

    public LocalDate getMaximum() { return maximum; }
    public void setMaximum(LocalDate value) { this.maximum = value; }

    public LocalDate getMinimum() { return minimum; }
    public void setMinimum(LocalDate value) { this.minimum = value; }
}