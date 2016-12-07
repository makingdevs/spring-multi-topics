statusListener(OnErrorConsoleStatusListener)

def appenderList = ["ROLLING"]
def dir = "."

appender("ROLLING", RollingFileAppender) {
    encoder(PatternLayoutEncoder) {
        // Pattern = "%d %level %thread %mdc %logger - %m%n"
        pattern = "%d{HH:mm:ss.SSS} [%thread] %highlight(%-5level) %cyan(%logger{15}) - %msg %n"
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        FileNamePattern = "${dir}/logs/business-%d{yyyy-MM}.log"
    }
}

//logger 'org.springframework', WARN
logger 'org.springframework.beans.factory',INFO
logger 'org.springframework.transaction',DEBUG
logger 'org.springframework.orm.jpa',DEBUG
root(INFO, appenderList)