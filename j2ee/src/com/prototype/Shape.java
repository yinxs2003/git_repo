package com.prototype;

public abstract class Shape implements Cloneable {
    protected String type;
    private String id;

    abstract void draw();

    String getType() {
        return type;
    }

    String getId() {

        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
