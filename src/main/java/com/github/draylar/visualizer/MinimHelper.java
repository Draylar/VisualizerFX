package com.github.draylar.visualizer;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 * Class required for Minim, as per Minim documentation.
 */
public class MinimHelper
{
    public MinimHelper() {
    }

    public String sketchPath(String fileName) {
        return "" + fileName;
    }

    public InputStream createInput(String fileName) {
        FileInputStream is = null;

        try {
            is = new FileInputStream(this.sketchPath(fileName));
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return is;
    }
}
