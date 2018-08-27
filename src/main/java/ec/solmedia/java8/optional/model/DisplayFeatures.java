package ec.solmedia.java8.optional.model;

import java.util.Optional;

public class DisplayFeatures {

    private final String size; // In inches
    private final Optional<ScreenResolution> resolution;

    /**
     * Optional in constructor?, please read:
     * http://blog.joda.org/2015/08/java-se-8-optional-pragmatic-approach.html
     * @param size
     * @param resolution 
     */
    public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
        this.size = size;
        this.resolution = resolution;
    }

    public String getSize() {
        return size;
    }

    public Optional<ScreenResolution> getResolution() {
        return resolution;
    }
}
