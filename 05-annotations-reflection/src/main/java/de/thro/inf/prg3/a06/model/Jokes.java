package de.thro.inf.prg3.a06.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Jokes {
    @SerializedName("total")
    private int total;
    @SerializedName("result")
    private Joke[] result;
}