package com.cs3250;

import java.util.*;
public class VerifyArgs {
    private String rawArg;
    private boolean andMatch;
    private ArrayList<Pair> pairs;

    public VerifyArgs(String _rawArg) {
        rawArg = _rawArg.toLowerCase();
        pairs = new ArrayList<>();
        andMatch = true;
    }

    public void sepAndOr() {
        rawArg = rawArg.trim();
        String[] sepArgs;

        if(rawArg.length() == 1)
        {

        }

        if (rawArg.equals("")) {
            return; //print everything
        }

        //search or " orMatch" if so, cut it off
        if (rawArg.contains(" ormatch")) {
            rawArg = rawArg.replaceFirst(" ormatch", "");
            andMatch = false;
        }

        //search for " andMatch" if so cut it off
        else if (rawArg.contains(" andmatch"))
        {
            rawArg = rawArg.replaceFirst(" andmatch", "");
        }

        //split array pairs, if odd number, error
        sepArgs = rawArg.split(" ");
        if (sepArgs.length % 2 != 0) {
            throw new IllegalArgumentException("incorrect syntax, please try again");
        } else {
            for (int i = 0; i < sepArgs.length; ++i) {
                if (sepArgs[i].equals("^")) {
                    com.cs3250.Operator thing = Operator.FIRST;
                    pairs.add(new Pair(thing, sepArgs[++i].charAt(0)));
                } else if (sepArgs[i].equals("$")) {
                    Operator thing = Operator.LAST;
                    pairs.add(new Pair(thing, sepArgs[++i].charAt(0)));
                } else if (sepArgs[i].equals("*")) {
                    Operator thing = Operator.ANY;
                    pairs.add(new Pair(thing, sepArgs[++i].charAt(0)));
                } else if (sepArgs[i].matches("\\d+")) {
                    Operator thing = Operator.NUM;
                    pairs.add(new Pair(thing, Integer.parseInt(sepArgs[i]), sepArgs[++i].charAt(0)));
                } else {
                    throw new IllegalArgumentException("incorrect syntax, please try again");
                }
            }
        }
    }
    public boolean getAndMatch() {
        return andMatch;
    }
    public ArrayList<Pair> getPairs() {
        return pairs;
    }
}
