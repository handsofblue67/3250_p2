package com.cs3250.Search;

public class VerifyArgs
{
    public String rawArguments;
    public String[] separatedArguments;
    public boolean andMatch = true;
    public VerifyArgs(String _rawArguments)
    {
	rawArguments = _rawArguments;
    }

    public void separateAndOr()
    {
	rawArguments.trim();
	if(rawArguments.length == 0)
	{
	    return; //print everything
	}




    
    }





