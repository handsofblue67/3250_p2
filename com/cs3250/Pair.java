package com.cs3250;

public class Pair {
    protected char ch;
    protected int num;
    protected Special spec;

    public Pair(Special _spec, int _num, char _ch) {
        spec = _spec;
        num = _num;
        ch = _ch;
    }

    public Pair(Special _spec, char _ch) {
        spec = _spec;
        ch = _ch
    }

}
