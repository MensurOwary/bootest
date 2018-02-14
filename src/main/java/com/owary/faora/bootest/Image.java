package com.owary.faora.bootest;

public class Image {

    private String raw;
    private String full;
    private String regular;
    private String small;

    public Image(){

    }

    public Image(String raw, String full, String regular, String small) {
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "Image{" +
                "raw='" + raw + '\'' +
                ", full='" + full + '\'' +
                ", regular='" + regular + '\'' +
                ", small='" + small + '\'' +
                '}';
    }
}
