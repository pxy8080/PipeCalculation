package com.pyy.event;

public class ShowToastEvent {
    private String toast;
    public ShowToastEvent(String toast) {
        this.toast = toast;
    }
    public String getToast(){
        return toast;
    }
}
