package app.logger;

public class LoggerImplUpper  implements Logger{
    @Override
    public void log(String message) {
        System.out.println(message.toUpperCase());
    }
}
