
package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("m")
    @Expose
    private String m;

    /**
     * No args constructor for use in serialization
     *
     */
    public Media() {
    }

    public Media(String m) {
        super();
        this.m = m;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

}
