package com.wnavy.navigationview;

/**
 * Created by netcore on 024 01/24.
 */

public class Girl {
    private String name;
    private int imageId;

    public Girl(String name, int imageId) {
        this.imageId = imageId;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getImageId() {
        return this.imageId;
    }
}
