package com.codepath.viviantnguyen.clonestagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("fwXilEBWczGQQiuH35gaPBNm7Gwu6XVDK3dJYUp0")
                .clientKey("mZwZ0rCptlw3pTZdjAREuddqQTfGJj5ryl7jy8Jw")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
