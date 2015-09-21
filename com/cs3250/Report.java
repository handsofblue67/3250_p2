package com.cs3250;

import java.io.*;
import java.util.*;

public class Report {
    private Scanner scan;
    ParaSet pair;

    public Report(String _fileName, ParaSet _pair) {
        scan = new Scanner(new File(_fileName));
        pair = _pair;
    }

    public look() {
        while(scan.hasNext()) {
            String temp = scan.next();
            switch(pair.spec) {
                case ANY: {
                    for(int i = 0; i < temp.length; ++i) {
                        if(temp[i] == pair.ch){
                            return i+1;//need to create a match class
                        }
                    }
                }
            }
        }
    }

}