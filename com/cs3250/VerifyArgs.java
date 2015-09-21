package com.cs3250;

public class VerifyArgs {
    private String rawArg;
    private String[] sepArgs;
    private boolean andMatch = true;
    private ArrayList<ParaSet> pairs;

    public VerifyArgs(String _rawArg) {
        rawArg = _rawArg.toLowerCase();
        pairs = new ArrayList<paraSet>();
    }

    public void sepAndOr() {
        rawArg.trim();
    }

    if(rawArg.equals(""))

    {
        return; //print everything
    }

    //search or " orMatch" if so, cut it off
    if(rawArg.contains(" ormatch"))

    {
        rawArg.replaceFirst(" ormatch", "");
        andMatch = false;
    }

    //search for " andMatch" if so cut it off
    else if(rawArg.contains(" andmatch"))

    {
        rawArg.replaceFirst(" andmatch", "");
    }

    //split array pairs, if odd number, error
    sepArgs=rawArg.split(" ");
    if(sepArgs.length%2!=0)

    {
        throw ("invalid argument");
    }

    else

    {
        for (int i = 0; i < sepArgs.length; ++i) {
            if (sepArgs[i].equals("^"))
        }
        Special thing = FIRST;
        pairs.add(new ParaSet(thing, sepArgs[++i]));
    }

    else if(sepArgs[i].

    equals("$")

    )

    {
        Special thing = LAST;
        pairs.add(new ParaSet(thing, sepArgs[++i]));
    }

    else if(sepArgs[i].

    equals("*")

    )

    {
        Special thing = ANY;
        pairs.add(new ParaSet(thing, sepArgs[++i]));
    }

    else if(separatedArgs[i].

    matches("\\d+") {
        Special thing = NUM;
        pairs.add(new ParaSet(thing, sepArgs[i], sepArgs[++i]));
    }
}
