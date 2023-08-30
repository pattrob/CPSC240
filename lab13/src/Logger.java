import java.io.PrintWriter;

public class Logger {

    private static Logger theInstance;
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;

    // the writers for each of the three levels
    private PrintWriter error;
    private PrintWriter warning;
    private PrintWriter info;

    // by default, set them all to system.out
    private Logger() {
        error = new PrintWriter(System.out);
        warning = new PrintWriter(System.out);
        info = new PrintWriter(System.out);
    }

    public static synchronized Logger instance(){
        if(theInstance == null){
            theInstance = new Logger();
        }
        return theInstance;
    }


    // allow each of them to be set to something else
    public void setSevere(PrintWriter error) {
        this.error = error;
    }
    public void setWarning(PrintWriter warning) {
        this.warning = warning;
    }
    public void setInfo(PrintWriter info) {
        this.info = info;
    }

    // put a message into one of the outputs
    public void log(int level, String message) {
        PrintWriter out = null;
        String type = "";
        switch (level) {
            case ERROR:
                out = error;
                type = "ERROR";
                break;
            case WARNING:
                out = warning;
                type = "WARNING";
                break;
            case INFO:
                out = info;
                type = "INFO";
                break;
        }

        // if the logger is null, we ignore those messages
        if (out != null) {
            // put the message
            out.println(type + ": " + message);
            out.flush();
        }
    }
}

