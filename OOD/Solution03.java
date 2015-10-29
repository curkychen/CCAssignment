package yu;

import java.io.*;
import java.util.*;
import java.math.*;

import org.omg.CORBA.INTERNAL;

/**
 * 
 * @author zhengyu
 * 
 */

public class test {
   static String[] getTesla(int NumCars, int NumSUVs) {
        TeslaCar t = new TeslaCar();
        if(NumCars == 0 && NumSUVs == 0)
            return "no orders";
        else if(NumCars == 0) {
            t = new ModelX();
            return NumSUVs + "," + t.status();
        }
        else if(NumSUVs == 0) {
            t = new ModelP85();
            return NumCars + "," + t.status();
        }
        
        String result = "";
        t = new ModelP85();
        result = result + NumCars + "," + t.status();
        t = new ModelX();
        return result + "," + NumSUVs "," + t.status();
    }
}