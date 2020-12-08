
// OriginalLanguage.java

package com.android.javajsonapp;

import java.io.IOException;

public enum OriginalLanguage {
    EN, FR, IT, JA;

    public String toValue() {
        switch (this) {
            case EN: return "en";
            case FR: return "fr";
            case IT: return "it";
            case JA: return "ja";
        }
        return "en";
    }

    public static OriginalLanguage forValue(String value) throws IOException {
        if (value.equals("en")) return EN;
        if (value.equals("fr")) return FR;
        if (value.equals("it")) return IT;
        if (value.equals("ja")) return JA;
        throw new IOException("Cannot deserialize OriginalLanguage");
    }
}
