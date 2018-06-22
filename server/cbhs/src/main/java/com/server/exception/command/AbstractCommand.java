package com.server.exception.command;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public abstract class AbstractCommand {
	public abstract Object onException(Exception exception,HttpServletResponse response) throws IOException;
}
