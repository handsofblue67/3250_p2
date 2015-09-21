package com.cs3250;
import java.io.*;
import java.util.*;

class Search
{
    public static void main(String[] args)
    {
	try
	{
	    Scanner in = new Scanner(new File(args[0]));
	    VerifyArgs verify = new VerifyArgs(args[1]);
	}

	catch(FileNotFoundException e)
	{
	    System.out.println("WAY TO GO TIMMY!");
	}
    }
}
