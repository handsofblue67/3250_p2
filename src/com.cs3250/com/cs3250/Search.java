package com.cs3250;

import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.VerifyError;
import java.util.*;

public class Search {
    public static void main(String[] args) {
        //open file to be searched
        VerifyArgs verify = new VerifyArgs(args[1]);
        verify.sepAndOr();
        ArrayList<Pair> _pairs = verify.getPairs();
        //matches list will contain all hits
        //ArrayList<Match> matches = new ArrayList<Match>();
        //String theRegex = new String();
        // for (int i = 0; i < verify.pairs.size(); ++i) {
        //    //build regex
        //}
        String temp;
        boolean isMatch;
        int count = 0; //keeps track of line number
        //use each argument pair to search file
        Scanner scan = null;
        try {
            //if(args[1].matches("([(\\d+)(\\Q^\\E)(\\Q$\\E)(\\Q*\\E )](\\s)(.)*[(andMatch)(orMatch)]?")) {}
            scan = new Scanner(new File(args[0]));
            while (scan.hasNextLine()) {
                ++count;
                temp = scan.next().toLowerCase();
                isMatch = true;
                for (Pair _pair : _pairs) {
                    Operator op = _pair.getOp();
                    switch (op) {
                        case FIRST: {
                            isMatch = carrot(temp, _pair);
                            break;
                        }
                        case LAST: {
                            isMatch = money(temp, _pair);
                            break;
                        }
                        case NUM: {
                            isMatch = number(temp, _pair);
                            break;
                        }
                        case ANY: {
                            isMatch = astrix(temp, _pair);
                            break;
                        }
                    }
                    if (verify.getAndMatch() && !isMatch) {
                        break;
                    }

                    else if (!verify.getAndMatch() && isMatch) {
                        break;
                    }
                }
                if (isMatch) {
                    System.out.println(count + " " + temp);
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
        if (_pair.getNum() >= _compare.length()) {
            flag = false;
        } else if (_compare.charAt(_pair.getNum()) == _pair.getCh()) {
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