package com.cs3250;

import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.VerifyError;
import java.util.*;

/**public class that will search a file for matches
file must be input as first argument, and any subsequent parameters must be in quotations.*/
/**acceptable operator characters are ^(first character matches), $(last character matches), , *(any character matches) or any positive integer(nth character matches)
each operator must be followed by a single character to search for, separated by a space.*/
/**by default the program will search for all operator/character pairs by logical and, but an optional "ormatch" may follow the last character to be searched for (still inside quotation marks*/
public class Search {
    public static void main(String[] args) {
        try {
            int hits = 0; //keep track of number of hits, only used to make sure a match was found.
            ArrayList<Pair> _pairs = null; //list of all operator/character pairs
            VerifyArgs verify = null; //object of the class that manages the arguments
            //only call verify, if the arguments are in pairs, otherwise, print whole file
	    if (args.length == 2) {
                verify = new VerifyArgs(args[1]);
                verify.sepAndOr();
                _pairs = verify.getPairs();
            }
            String temp; //the string that will hold each string in the file
            boolean isMatch; //keeps track of the current state of a word being tested
            int count = 0; //keeps track of line number
            //use each argument pair to search file
            Scanner scan = null;
            try {
                scan = new Scanner(new FileReader(args[0]));
		//continue until end of file
                while (scan.hasNextLine()) {
                    ++count;//increment count each word read in (line number)
                    temp = scan.nextLine().toLowerCase(); //read in a line to search
                    isMatch = true; //true until proven false
                    if (_pairs != null) {//as long as there are some op/char pairs
			//iterate through the list of pairs
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
                                break;//by default, move to next word if any op/char pair is a mismatch
                            } else if (!verify.getAndMatch() && isMatch) {
                                break;//if ormatch was selected and a word gets a hit for any of the op/char pairs, break print, and move on
                            }
                        }
                    }

		    //print any hits
                    if (isMatch) {
                        System.out.println((count + " " + temp).trim());
                        ++hits;
                    }
                }

		//if no hits were found, print message
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
            System.out.println("incorrect syntax, please try again");
        } finally {
            System.out.println("");
        }
    }

    /** handles any integer value operator arguments*/
    public static boolean number(String _compare, Pair _pair) {
        boolean flag = false;
        if (_pair.getNum() >= _compare.length()) {
            flag = false;
        } else if (_compare.charAt(_pair.getNum()) == _pair.getCh()) {
            flag = true;
        }
        return flag;
    }

    /** handles any '$' operator arguments*/
    public static boolean money(String _compare, Pair _pair) {
        boolean flag = false;
        if (_compare.charAt(_compare.length() - 1) == _pair.getCh()) {
            flag = true;
        }
        return flag;
    }

    /** handles any '*' operator arguments*/
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
    /** handles any '^' operator arguments*/
    public static boolean carrot(String _compare, Pair _pair) {
        boolean flag = false;
        if (_compare.charAt(0) == _pair.getCh()) {
            flag = true;
        }
        return flag;
    }
}
