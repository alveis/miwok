package com.alveis.multiscreen_java;

public class Word {
    private String mDefaultTranslation;
    private String mMiworkTranslation;
    private int mImageResourceId = NO_IMAGE;
    private static final int NO_IMAGE = -1;

    public Word(String defaultTranslation, String miworkTranslation){
        mMiworkTranslation = miworkTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String defaultTranslation, String miworkTranslation, int imageResourceId){
        mMiworkTranslation = miworkTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
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

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return  mImageResourceId != NO_IMAGE;
    }
}
