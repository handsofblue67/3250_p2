package com.cs3250;

import java.util.*;
public class VerifyArgs {
    private String rawArg;
    private String[] sepArgs;
    private boolean andMatch;
    private ArrayList<Pair> pairs;

    public VerifyArgs(String _rawArg) {
        rawArg = _rawArg.toLowerCase();
        pairs = new ArrayList<Pair>();
        andMatch = true;

    }

    public void sepAndOr() {
        rawArg.trim();

        if (rawArg.equals("")) {
            return; //print everything
        }

        //search or " orMatch" if so, cut it off
        if (rawArg.contains(" ormatch")) {
            rawArg.replaceFirst(" ormatch", "");
            andMatch = false;
        }

        //search for " andMatch" if so cut it off
        else if (rawArg.contains(" andmatch"))
        {
            rawArg.replaceFirst(" andmatch", "");
        }

        //split array pairs, if odd number, error
        sepArgs = rawArg.split(" ");
        if (sepArgs.length % 2 != 0) {
            throw ("invalid argument");
        } else {
            for (int i = 0; i < sepArgs.length; ++i) {
                if (sepArgs[i].equals("^")) {
                    Operator thing = FIRST;
                    pairs.add(new Pair(thing, sepArgs[++i]));
                } else if (sepArgs[i].equals("$")) {
                    Operator thing = LAST;
                    pairs.add(new Pair(thing, sepArgs[++i]));
                } else if (sepArgs[i].equals("*")) {
                    Operator thing = ANY;
                    pairs.add(new Pair(thing, sepArgs[++i]));
                } else if (separatedArgs[i].matches("\\d+")) {
                    Operator thing = NUM;
                    pairs.add(new Pair(thing, sepArgs[i], sepArgs[++i]));
                }
            }
        }
    }
    public String getRawArg() {
        return rawArgl;
    }

    public String[] getSepArgs() {
        return sepArgs;
    }

    public boolean getAndMatch() {
        return andMatch;
    }
    public ArrayList<Pair> getPairs() {
        return pairs;
    }
}
