package com.phon.elibrary;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class ELibrary extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
