import java.util.*;
import java.io.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainRunner
{
    public static void main(String args[])
    {
        try
        {   
            Runtime rt = Runtime.getRuntime();
            System.out.print("Compiling..");
            if(args.length == 0){
                System.out.println("Error: Must provide the class to be tested (e.g. java MainRunner MyGraph.java");
                    return;
            }
            Process proc = rt.exec("javac "+args[0]);
            if(!new File("MyTest.java").exists()){
                System.out.println("Error: Test class MyTest.java not found.");
                return;
            }
            proc = rt.exec("javac -cp .:junit.jar:hamcrest.jar MyTest.java");
            System.out.println("done.");
            long start = System.currentTimeMillis();
            System.out.print("Running..");
            
            proc = rt.exec("java -cp .:junit.jar:hamcrest.jar MyTestRunner");
            System.out.println("done.");
            InputStream stdin = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("Result:");
            String lines = "";
            while ( (line = br.readLine()) != null){
                    lines = lines + line+"\n";
            }
            if(lines.isEmpty())
                System.out.println("All tests passed.");
            else    
                System.out.println(lines);
            long end = System.currentTimeMillis();

            long duration = end - start;
            
            System.out.println("Duration: "+duration+" ms");

            // int exitVal = proc.waitFor();            
            // System.out.println("Process exitValue: " + exitVal);
        } catch (Throwable t)
          {
            t.printStackTrace();
          }
    }
}


class MyTestRunner{
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MyTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }       
    }
}

