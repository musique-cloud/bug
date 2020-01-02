package com.hlh.bug.util;

import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

import java.text.MessageFormat;

public class MyLogFace implements MyLogInf {

    /**空数组*/
    private static final Object[] EMPTY_ARRAY = new Object[] {};
    /**全类名*/
    private static final String FQCN = MyLogFace.class.getName();

    private org.slf4j.Logger _log = null;

    public void setName(String clz) {
        _log = org.slf4j.LoggerFactory.getLogger(clz);
    }

    private boolean isDebugEnabled() {
        return _log.isDebugEnabled();
    }

    private boolean isInfoEnabled() {
        return _log.isInfoEnabled();
    }

    private boolean isWarnEnabled() {
        return _log.isWarnEnabled();
    }

    private boolean isErrorEnabled() {
        return _log.isErrorEnabled();
    }

    @Override
    public void debug(String message, Object... args) {
        if (this.isDebugEnabled()) {
            if (args != null && args.length > 0) {
                MessageFormat temp = new MessageFormat(message);
                message = temp.format(args);
            }
            getLocationAwareLogger(1).log(null, FQCN, LocationAwareLogger.DEBUG_INT, message, EMPTY_ARRAY, null);
        }

    }

    @Override
    public void info(String message, Object... args) {
        if (this.isInfoEnabled()) {
            if (args != null && args.length > 0) {
                MessageFormat temp = new MessageFormat(message);
                message = temp.format(args);
            }
            getLocationAwareLogger(1).log(null, FQCN, LocationAwareLogger.INFO_INT, message, EMPTY_ARRAY, null);
        }
    }

    @Override
    public void warn(String message, Object... args) {
        if (this.isWarnEnabled()) {
            if (args != null && args.length > 0) {
                MessageFormat temp = new MessageFormat(message);
                message = temp.format(args);
            }
            getLocationAwareLogger(1).log(null, FQCN, LocationAwareLogger.WARN_INT, message, EMPTY_ARRAY, null);
        }
    }

    @Override
    public void error(String message, Object... args) {
        if (this.isErrorEnabled()) {
            if (args != null && args.length > 0) {
                MessageFormat temp = new MessageFormat(message);
                message = temp.format(args);
            }
            getLocationAwareLogger(1).log(null, FQCN, LocationAwareLogger.ERROR_INT, message, EMPTY_ARRAY, null);
        }
    }

    /**
     * 获取栈中类信息
     * @param stackDepth 栈深（下标） 2：调用者类信息
     * @return org.slf4j.spi.LocationAwareLogger
     */
    private static LocationAwareLogger getLocationAwareLogger(final int stackDepth) {
        /**通过堆栈信息获取调用当前方法的类名和方法名*/
        JavaLangAccess access = SharedSecrets.getJavaLangAccess();
        Throwable throwable = new Throwable();
        StackTraceElement frame = access.getStackTraceElement(throwable, stackDepth);
        return (LocationAwareLogger) LoggerFactory.getLogger(frame.getClassName());
    }

}
