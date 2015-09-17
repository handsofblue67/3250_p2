package com.cs3250.Search;
import java.io.*;
import java.util.*;

class Search
{
    public static void main(String[] args)
    {
	Scanner in = new Scanner(new File(args[0]));
	VerifyArgs verify = new VerifyArgs(args[1]);
    }
}
