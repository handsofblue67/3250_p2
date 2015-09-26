package com.cs3250;

import java.io.*;
import java.util.*;

public class Search {
    public static void main(String[] args) {
        VerifyArgs verify = new VerifyArgs(args[1]);
        verify.sepAndOr();
        ArrayList<Pair> _pairs = verify.getPairs();
        Scanner scan = null;
        //use each argument pair to search file
        try {
            //open file to be searched
            scan = new Scanner(new File(args[0]));
            String temp = null;
            Pair pair;
            boolean isMatch = false;
            int count = 0; //keeps track of line number
            if(verify.getAndMatch()){
                while (scan.hasNextLine()) {
                    temp = scan.next().toLowerCase();
                    ++count;
                    andOut:
                    while(true) {
                        for (Pair _pair : _pairs) {
                            pair = _pair;
                            Operator op = pair.getOp();
                            isMatch = true;
                            while (isMatch) {
                                switch (op) {
                                    case FIRST: {
                                        isMatch = carrot(temp, pair);
                                        break;
                                    }
                                    case LAST: {
                                        isMatch = money(temp, pair);
                                        break;
                                    }
                                    case EXISTS: {
                                        isMatch = astrix(temp, pair);
                                        break;
                                    }
                                    case NUM: {
                                        isMatch = number(temp, pair);
                                        break;
                                    }
                                }
                                if (!isMatch) {
                                    break andOut;
                                }
                            }
                        }
                        break andOut;
                    }
                    if(isMatch) {
                        System.out.println(count + " " + temp);
                    }
                }
            } else {
                while (scan.hasNextLine()) {
                    temp = scan.next().toLowerCase();
                    orOut:
                    while (true) {
                        ++count;
                        for (Pair _pair : _pairs) {
                            isMatch = false;
                            pair = _pair;
                            Operator op = pair.getOp();
                            while (!isMatch) {
                                switch (op) {
                                    case FIRST: {
                                        isMatch = carrot(temp, pair);
                                        break;
                                    }
                                    case LAST: {
                                        isMatch = money(temp, pair);
                                        break;
                                    }
                                    case NUM: {
                                        isMatch = number(temp, pair);
                                        break;
                                    }
                                    case EXISTS: {
                                        isMatch = astrix(temp, pair);
                                        break;
                                    }
                                }
                                if (isMatch) {
                                    break orOut;
                                }
                            }
                        }
                    }
                    if(isMatch) {
                        System.out.println(count + " " + temp);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }

    public static boolean number(String _compare, Pair _pair) {
        boolean flag = false;
        if(_pair.getNum() >= _compare.length()) {
            flag = false;
        }
        else if (_compare.charAt(_pair.getNum()) == _pair.getCh()) {
            flag = true;
        }
        return flag;
    }

    public static boolean money(String _compare, Pair _pair) {
        boolean flag = false;
        if (_compare.charAt(_compare.length() - 1) == _pair.getCh()) {
            flag = true;
        }
        return flag;
    }

    public static boolean astrix(String _compare, Pair _pair) {
        boolean flag = false;
        for (int i = 0; i < _compare.length(); ++i) {
            if (_compare.charAt(i) == _pair.getCh()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean carrot(String _compare, Pair _pair) {
        boolean flag = false;
        if (_compare.charAt(0) == _pair.getCh()) {
            flag = true;
        }
        return flag;
    }
}

