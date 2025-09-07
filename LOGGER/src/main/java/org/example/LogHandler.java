package org.example;

abstract class LogHandler {
  public static final int INFO = 1;
  public static final int DEBUG = 2;
  public static final int ERROR = 3;
  protected int level;
  protected LogHandler nextLogger;
  protected LogAppender appender; // the appender where we need to append the logs
  // Constructor to initialize with appender
  public LogHandler(int level, LogAppender appender) {
    this.level = level;
    this.appender = appender;
  }

  // Set the next logger in the chain
  public void setNextLogger(LogHandler nextLogger) {
    this.nextLogger = nextLogger;
  }

  // Corrected to use LogLevel instead of int for consistency
  public void logMessage(int level, String message) {
    if (this.level >= level) {
      // Convert int level to LogLevel enum
      LogLevel logLevel = intToLogLevel(level);
      LogMessage logMsg = new LogMessage(logLevel, message);
      // Use the appender to log
        if (appender != null) {
            appender.append(logMsg);
        }
      write(message);
    }
    else if (nextLogger != null) {
        nextLogger.logMessage(level, message);
    }
  }

  // Helper method to convert int level to LogLevel enum
  private LogLevel intToLogLevel(int level) {
    switch (level) {
      case INFO:
        return LogLevel.INFO;
      case DEBUG:
        return LogLevel.DEBUG;
      case ERROR:
        return LogLevel.ERROR;
      default:
        return LogLevel.INFO;
    }
  }

  // Each concrete logger will implement its own writing mechanism
  abstract protected void write(String message);
}