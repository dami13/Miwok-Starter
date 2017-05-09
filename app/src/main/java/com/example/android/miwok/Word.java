package com.example.android.miwok;

/**
 * Created by Dami on 23.04.2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_SOUND_PROVIDED = -1;
    private int mSoundResourceId = NO_SOUND_PROVIDED;
    private static final int SOUND_IMAGE_RESOURCE= R.drawable.ic_play_arrow_black_24dp;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSoundResourceId = audioResourceId;
    }

    public int getSoundResourceId() {
        return mSoundResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getSoundImageResource() {
        return SOUND_IMAGE_RESOURCE;
    }

    //True if it has Image
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean hasSound() {
        return mSoundResourceId != NO_SOUND_PROVIDED;
    }
}
