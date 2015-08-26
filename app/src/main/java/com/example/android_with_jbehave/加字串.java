package com.example.android_with_jbehave;


public class 加字串 {

    private StringBuffer 漢字資料 = new StringBuffer();
    private int 次數 = 0;

    public void 加新字串(String 字串) {
        漢字資料.append(字串);
        次數++;
    }

    public int 全部長度() {
        return 漢字資料.toString().length();
    }

    public int 全部次數() {
        return 次數;
    }

}
