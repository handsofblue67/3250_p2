package com.cs3250;

public class Match {
    private int lineNum;
    private String instance;

    public Match(int _lineNum, String _instance) {
        lineNum = _lineNum;
        instance = _instance;
    }

    public String getInstance(){
        return instance;
    }

    public int getLineNum(){
        return lineNum;
    }
}