package com.phon.elibrary;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class Utility {
    public static void displayFragment(Fragment fragment, FragmentManager fragmentManager, @IdRes int fragmentContainer) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
