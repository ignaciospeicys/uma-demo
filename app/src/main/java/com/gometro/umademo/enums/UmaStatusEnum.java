package com.gometro.umademo.enums;

import com.gometro.umademo.R;

public enum UmaStatusEnum {

    PAUSED(R.string.uma_status_inactive),
    RUNNING(R.string.uma_status_active);

    private int textId;

    UmaStatusEnum(int textId) {
        this.textId = textId;
    }

    public int getTextId() {
        return textId;
    }
}
