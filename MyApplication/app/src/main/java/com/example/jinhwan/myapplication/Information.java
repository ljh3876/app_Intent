package com.example.jinhwan.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Jinhwan on 2017-04-06.
 */

public class Information implements Parcelable{
    String name;
    String call;
    String[] menu;
    String homepage;
    String date;
    int category;
    public Information(String name,String call, String[] menu, String homepage,String date,int category){
        this.name = name;
        this.call = call;
        this.menu = menu;
        this.homepage = homepage;
        this.date = date;
        this.category = category;
    }

    protected Information(Parcel in) {
        name = in.readString();
        call = in.readString();
        menu = in.createStringArray();
        homepage = in.readString();
        date = in.readString();
        category = in.readInt();
    }

    public static final Creator<Information> CREATOR = new Creator<Information>() {
        @Override
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        @Override
        public Information[] newArray(int size) {
            return new Information[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(call);
        dest.writeStringArray(menu);
        dest.writeString(homepage);
        dest.writeString(date);
        dest.writeInt(category);
    }
}
