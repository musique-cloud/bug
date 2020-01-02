package com.hlh.bug.util;

public abstract interface MyLogInf {

    void debug(String paramString, Object... args);

    void info(String paramString, Object... args);

    void warn(String paramString, Object... args);

    void error(String paramString, Object... args);

}
