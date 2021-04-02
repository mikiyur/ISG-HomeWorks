package app.logger;

public class LoggerImplLower implements Logger{
    @Override
    public void log(String message) {
        System.out.println(message.toLowerCase());
    }

}
