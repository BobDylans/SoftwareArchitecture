package com.Test02.eventSystem;

public class KWICSubject extends Subject {
    public void startKWIC(){
        for (int i = 0;i<3;i++){
            super.notifyOneObserver(i);
        }
    }
}