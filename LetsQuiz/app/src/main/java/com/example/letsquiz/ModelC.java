package com.example.letsquiz;

public class ModelC {
    String Qui;
    String O1;
    String O2;
    String O3;
    String O4;
    String Ans;

    public ModelC(String qui, String o1, String o2, String o3, String o4, String ans) {
        this.Qui = qui;
        O1 = o1;
        O2 = o2;
        O3 = o3;
        O4 = o4;
        Ans = ans;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }

    public String getO1() {
        return O1;
    }

    public void setO1(String o1) {
        O1 = o1;
    }

    public String getO2() {
        return O2;
    }

    public void setO2(String o2) {
        O2 = o2;
    }

    public String getO3() {
        return O3;
    }

    public void setO3(String o3) {
        O3 = o3;
    }

    public String getO4() {
        return O4;
    }

    public void setO4(String o4) {
        O4 = o4;
    }

    public String getQui() {
        return Qui;
    }

    public void setQui(String qui) {
        Qui = qui;
    }
}
