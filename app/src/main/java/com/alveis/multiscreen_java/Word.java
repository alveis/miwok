package com.alveis.multiscreen_java;

public class Word {
    private String mDefaultTranslation;
    private String mMiworkTranslation;

    public Word(String defaultTranslation, String miworkTranslation){
        mMiworkTranslation = miworkTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public String getMiworkTranslation(){
        return mMiworkTranslation;
    }

    /**
     * @return
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
}
