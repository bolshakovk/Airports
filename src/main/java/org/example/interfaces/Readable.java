package org.example.interfaces;

import java.io.IOException;

public interface Readable {
    void readFile();
    void findValue(String name) throws IOException;

    void setArg(String arg);
    int getSize();
    long getTimeHasPassed();
}
