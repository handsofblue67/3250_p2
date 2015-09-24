package com.cs3250;

import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.VerifyError;
import java.util.*;

enum Operator {FIRST, LAST, ANY, NUM};

class Search {
    public static void main(String[] args) {
        try {
            //open file to be searched
            Scanner scan = new Scanner(new File(args[0]));
        }
//{
        catch (FileNotFoundException e) {
            System.out.println("WAY TO GO TIMMY!");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("out of bounds");
        }
        //if(args[1].matches("([(\\d+)(\\Q^\\E)(\\Q$\\E)(\\Q*\\E )](\\s)(.)*[(andMatch)(orMatch)]?")) {}
        VerifyArgs verify = new VerifyArgs(args[1]);
        verify.sepAndOr();
        ArrayList<Pair> _pairs = verify.getPairs();
        //matches list will contain all hits
        ArrayList<Match> matches = new ArrayList<Match>();
        //String theRegex = new String();
        // for (int i = 0; i < verify.pairs.size(); ++i) {
        //    //build regex
        //}
        Pair pair;
        String temp;
        boolean isMatch = false;
        //use each argument pair to search file
        while (scan.hasNext()) {
            temp = scan.Next();
            int count = 1; //keeps track of line number
            for(int i = 0; i < _pairs.size(); ++i) {
                pair = _pairs.get(i);
                if (verify.getAndMatch() == true && isMatch) {
                    switch (pair.getOp()) {
                        case (FIRST): {
                            if (carot(temp, pair)) {
                                isMatch = true;
                            }
                            else {
                                isMatch = false;
                            }
                            break;
                        }
                        case (LAST): {
                            if (dollar(temp, pair)) {
                                isMatch = true;
                            }
                            else {
                                isMatch = false;
                            }
                            break;
                        }
                        case (NUM): {
                            if (number(temp, pair)) {
                                isMatch = true;
                            }
                            else {
                                isMatch = false;
                            }
                            break;
                        }
                        case (ANY): {
                            case (FIRST): {
                                if (carot(temp, pair)) {
                                    isMatch = true;
                                }
                                else {
                                    isMatch = false;
                                }
                            }
                            else {
                                isMatch = false;
                            }
                            break;
                        }
                    }
                } else {
                    switch (pair.getOp()) {
                        case (FIRST): {
                            if (carot(temp, pair)) {

                            }
                        }
                        case (LAST): {
                            if (dollar(temp, pair)) {
                                isMatch = true;
                            }
                            else {
                                isMatch = false;
                            }
                            break;

                        }
                    }
                    case (NUM): {
                        if (number(temp, pair)) {
                        }
                        else {
                            isMatch = false;
                        }
                        break;
                    }
                }
                case (ANY): {
                    if (astrix(temp, pair)) {
                        isMatch = true;
                    }
                    else {
                        isMatch = false;
                    }
                    break;
                }
            }
        }
        if(isMatch) {
            System.out.println(count + " " + temp);
        }
        ++count;
    }
}

    public static boolean number(String _compare, Pair _pair)
    {
        boolean flag = false;
        if (_compare[_pair.num] == _pair.ch)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean money(String _compare, Pair _pair) {
        boolean flag = false;
        if (_compare[(_compare.length - 1)] == _pair.ch) {
            flag = true;
        }
        return flag;
    }

    public static boolean astrix(String _compare, Pair _pair) {
        boolean flag = false;
        for (int i = 0; i < _compair.length; ++i) {
            if (_compare[i] == _pair.ch) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean carot(String _compare, Pair _pair) {
        boolean flag = false;
        if (_compare[0] == _pair.ch) {
            flag = true;
        }
        return flag;
    }
}

