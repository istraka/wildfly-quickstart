/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.helloworld;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 *
 * <p>
 * The servlet is registered and mapped to /HelloServlet using the {@linkplain WebServlet
 * @HttpServlet}.
 * </p>
 *
 * @author Pete Muir
 *
 */
@WebServlet("/HelloWorld")
public class HelloWorldServlet extends HttpServlet {

    static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        req.setAttribute("a", "b");
        PrintWriter writer = resp.getWriter();

        writer.println(PAGE_HEADER);
        writer.println("<h1>Hello World!</h1>");
        writer.println("<br>ATTRIBUTES:<br>");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            writer.println(s + ":" + req.getAttribute(s) + "<br>");
        }
        writer.println("<br>===========<br>");
        writer.println("<br>PARAMS:<br>");
        Enumeration<String> paramsNames = req.getParameterNames();
        while (paramsNames.hasMoreElements()) {
            String s = paramsNames.nextElement();
            writer.println(s + ":" + req.getParameter(s) + "<br>");
        }
        writer.println("<br>===========<br>");
        writer.println(PAGE_FOOTER);
        writer.close();
    }

}
