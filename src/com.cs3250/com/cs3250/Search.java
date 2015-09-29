package com.cs3250;

import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.VerifyError;
import java.util.*;

public class Search {
    public static void main(String[] args) {
        try {
            int hits = 0;
            ArrayList<Pair> _pairs = null;
            VerifyArgs verify = null;
            if (args.length == 2) {
                verify = new VerifyArgs(args[1]);
                verify.sepAndOr();
                _pairs = verify.getPairs();
            }
            String temp;
            boolean isMatch;
            int count = 0; //keeps track of line number
            //use each argument pair to search file
            Scanner scan = null;
            try {
                scan = new Scanner(new FileReader(args[0]));
                while (scan.hasNextLine()) {
                    ++count;
                    temp = scan.nextLine().toLowerCase();
                    isMatch = true;
                    if (_pairs != null) {

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
                            } else if (!verify.getAndMatch() && isMatch) {
                                break;
                            }
                        }
                    }
                    if (isMatch) {
                        System.out.println((count + " " + temp).trim());
                        ++hits;
                    }
                }
                if(hits == 0) {
                    System.out.println("no such match");
                }
            } catch (FileNotFoundException e) {
                System.out.println("incorrect file, please try again");
            } catch (IndexOutOfBoundsException c) {
                System.out.println("incorrect file, please try again");
            } finally {
                if (scan != null) {
                    scan.close();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("");
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
