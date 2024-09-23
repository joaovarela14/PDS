import java.io.*;
import java.util.*;

import static java.lang.Thread.sleep;

public class PrintJob implements Runnable{
    private Document doc;

    private String text;
    private int jobID;
    private static int jobCounter = 0;


    public PrintJob(Document doc) {
        this.doc = doc;
        this.jobID = jobCounter++;
        this.text = readDocument();
    }

    @Override
    public void run() {
        try {
            sleep(1500  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished Job " + this.jobID + ": " + readDocument());
    }

    @Override
    public String toString() {

        return ("Job " + this.jobID + ": " + text);
    }

    public int getID() {
        return this.jobID;
    }

    private String readDocument() {
        StringBuilder content = new StringBuilder();
        String[] lines = this.doc.getContent();
        content.append(lines[0], 0, Math.min(20, lines[0].length() - 1)).append("...");
        return content.toString();
    }
}