package ru.urvanov.javaexamples.commonscli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App 
{
    public static void main( String[] args )
    {
        Options options = new Options();
        
        options.addOption("v", "Verbose output");
        
        // -s or --secondOption
        options.addOption("s", "secondOption", false,
                "Just a second option.");
        
        // -f <file >or --file <file>
        options.addOption("f", "file", true,
                "File to process");
        
        options.addRequiredOption("r", "requiredOption",
                false, "Required option example");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse( options, args);
        } catch (ParseException pe) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "myappname", options );
            System.exit(1);
        }
        if (cmd.hasOption("v")) {
            System.out.println("We have verbose option");
            // process verbose option key.
        }
        if (cmd.hasOption("f")) {
            System.out.println("FileName: " + cmd.getOptionValue("f"));
        }
    }
}
