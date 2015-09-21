package com.cs3250;

public class VerifyArgs
{
    public String rawArguments;
    public String[] separatedArgs;
    public boolean andMatch = true;
    ArrayList<String[]> pairs = new ArrayList<String[]>();
    public VerifyArgs(String _rawArguments)
    {
	rawArguments = _rawArguments.toLowerCase();
    }

    public void separateAndOr()
    {
	rawArguments.trim();

	if(rawArguments.equals(""))
	{
	   return; //print everything
	}
	
	//search or " orMatch" if so, cut it off
	if(rawArguments.contains(" ormatch"))
	{
	    rawArguments.replaceFirst(" ormatch", "");
	    andMatch = false;
	}
	
	//search for " andMatch" if so cut it off
	else if(rawArguments.contains(" andmatch"))
	{
	    rawArguments.replaceFirst(" andmatch", "");
	}
	
	//split array pairs, if odd number, error
	separatedArgs = rawArguments.split(" ");
	if(separatedArgs.length % 2 != 0)
	{
	    //invalid arguments
	}

	else
	{
	    for (int i = 0; i < separatedArgs.length; ++i)
	    {
		if(separatedArgs[i].equals("^"))
		{
		    pairs.add({"^", ++separatedArgs[i]('^)})
		}

		else if(separatedArgs[i].equals("$"))
		{
		    //create object of searchPair('&', ++separatedArgs)
		}

		else if(separatedArgs[i].equals("*"))
		{
		    //create object of searchPair('*' ++separatedArgs)
		}

		//else if(separatedArgs[i]
	    }
	}
    }
}
