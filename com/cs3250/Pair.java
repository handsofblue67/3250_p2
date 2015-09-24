package com.cs3250;

public class Pair {
    private char ch;
    private int num;
    private Operator op;

    public Pair(Operator _op, int _num, char _ch) {
        op = _op;
        num = _num;
        ch = _ch;
    }

    public Pair(Operator _op, char _ch) {
        op = _op;
        ch = _ch;
    }

    public Operator getOp() {
        return op;
    }

    public char getCh() {
        return ch;
    }

    public int getNum() {
        return num;
    }
}
