package com.cs3250;

import java.io.*;
import java.util.*;

protected enum Special {FIRST, LAST, ANY, NUM};

class Search {
    public static void main(String[] args) {
        try {
            //open file to be searched
            scan = new Scanner(new File(_fileName));
        }
        VerifyArgs verify = new VerifyArgs(args[1]);
        //if(args[1].matches("(((\\d)*+'^'+'$'+'*')(\\s)([a-zA-z])*(andMatch+orMatch)?"))
        //{
        //   System.out.println("cool");
        //}

  	    catch(FileNotFoundException e) {
            System.out.println("WAY TO GO TIMMY!");
        }
        ArrayList<Match> matches = new ArrayList<Match>();
        verify.sepAndOr();
        while(!verify.pairs.isEmpty()) {
            if(look(verify.pairs.get(0))) {
                matches.add(verify.pairs.get(0));
            }
            verify.pairs.remove(0);
        }
    }

    public void look(Pair _pair) {
        int count = 1;
        while (scan.hasNext()) {
            String temp = scan.next();
            switch (_pair.spec) {
                case ANY: {
                    for (int i = 0; i < temp.length; ++i) {
                        if (temp[i] == _pair.ch) {
                            matches.add(count, temp);
                        }
                    }
                    ++count;
                    break;
                }
                case FIRST: {
                    if (temp[0] == _pair.ch) {
                        matches.add(count, temp);
                    }
                    ++count;
                    break;
                }
                case LAST: {
                    if(temp[temp.length] == _pair.ch) {
                        matches.add(count, temp);
                    }
                    ++count;
                    break;
                }
                case NUM: {
                    if(temp[_pair.num] == _pair.ch) {
                        matches.add(count, temp);
                    }
                    ++count;
                    break;
                }
            }
        }
    }
}
