package com.example.tushar.bro.entities;

import android.os.Parcel;
import android.os.Parcelable;



public class Brother implements Parcelable {
  private int brotherId;
    private String brotherName;

private String brotherwhyJoin;
    private String brotherPicture;
    private String brothermajor;
    private String brotherCrossSemester;
    private String brotherFunFact;


    public Brother(int brotherId, String brotherName, String brotherwhyJoin, String brotherPicture, String brothermajor, String brotherCrossSemester, String brotherFunFact) {
        this.brotherId = brotherId;
        this.brotherName = brotherName;
        this.brotherwhyJoin = brotherwhyJoin;
        this.brotherPicture = brotherPicture;
        this.brothermajor = brothermajor;
        this.brotherCrossSemester = brotherCrossSemester;
        this.brotherFunFact = brotherFunFact;
    }

    protected Brother(Parcel in) {
        brotherId=in.readInt();
        brotherName=in.readString();
        brotherwhyJoin=in.readString();
        brotherPicture=in.readString();
        brothermajor=in.readString();
        brotherCrossSemester=in.readString();
        brotherFunFact=in.readString();


    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(brotherId);
        parcel.writeString(brotherName);
        parcel.writeString(brotherwhyJoin);
        parcel.writeString(brotherPicture);
        parcel.writeString(brothermajor);
        parcel.writeString(brotherCrossSemester);
        parcel.writeString(brotherFunFact);


    }

    public int getBrotherId() {
        return brotherId;
    }

    public String getBrotherName() {
        return brotherName;
    }

    public String getBrotherwhyJoin() {
        return brotherwhyJoin;
    }

    public String getBrotherPicture() {
        return brotherPicture;
    }

    public String getBrothermajor() {
        return brothermajor;
    }

    public String getBrotherCrossSemester() {
        return brotherCrossSemester;
    }

    public String getBrotherFunFact() {
        return brotherFunFact;
    }

    public static final Creator<Brother> CREATOR = new Creator<Brother>() {
        @Override
        public Brother createFromParcel(Parcel in) {
            return new Brother(in);
        }

        @Override
        public Brother[] newArray(int size) {
            return new Brother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


}
