package com.ppc.tokokomputer;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemAnimator extends DefaultItemAnimator {

    public CustomItemAnimator() {
        setAddDuration(300);
        setRemoveDuration(300);
        setMoveDuration(300);
        setChangeDuration(300);
    }
}