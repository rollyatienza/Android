package com.mydashboardgroup.optumtracker.optumtracker.Class;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by ratienz2 on 6/8/2017.
 */

public class Events {

    private int mMasterID;
    private String mName;
    private String mDescription;
    private String mDate;
    private String mCoordinator;
    private String mAddress;
    private String mLatitude;
    private String mLongitude;

    private boolean mActive;
    private String mModifyDate;
    private boolean mIsBatchProcessing;

    public Events(){

    }

    public int getmMasterID() {
        return mMasterID;
    }

    public void setmMasterID(int mMasterID) {
        this.mMasterID = mMasterID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmCoordinator() {
        return mCoordinator;
    }

    public void setmCoordinator(String mCoordinator) {
        this.mCoordinator = mCoordinator;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    public String getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(String mLongitude) {
        this.mLongitude = mLongitude;
    }

    public boolean ismActive() {
        return mActive;
    }

    public void setmActive(boolean mActive) {
        this.mActive = mActive;
    }

    public String getmModifyDate() {
        return mModifyDate;
    }

    public void setmModifyDate(String mModifyDate) {
        this.mModifyDate = mModifyDate;
    }

    public boolean ismIsBatchProcessing() {
        return mIsBatchProcessing;
    }

    public void setmIsBatchProcessing(boolean mIsBatchProcessing) {
        this.mIsBatchProcessing = mIsBatchProcessing;
    }





}
