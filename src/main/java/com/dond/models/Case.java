package com.dond.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Case {
    private int caseNumber;
    private int caseValue;
    private boolean isOpen = false;

    public Case(int caseNumber, int caseValue) {
        this.caseNumber = caseNumber;
        this.caseValue = caseValue;
        isOpen = false;
    }

    public int getCaseValue() {
        return caseValue;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getDisplay(){
        if (!isOpen){
            return "[" + caseNumber + "]";
        } else {
            return "---";
        }
    }

    public boolean isOpen() {
        return isOpen;
    }


}
