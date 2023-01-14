/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2023-01-13 21:49:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Patient;

public final class addData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("models.Patient");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

    Patient patient = (Patient)request.getAttribute("patient");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <title>Document</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/addData.css\">\n");
      out.write("  <style>\n");
      out.write("    button{\n");
      out.write("      border: none;\n");
      out.write("      cursor: pointer;\n");
      out.write("      appearance: none;\n");
      out.write("      background-color: inherit;\n");
      out.write("      margin-left:10px;\n");
      out.write("      margin-top:20px;\n");
      out.write("    }\n");
      out.write("    button:hover {\n");
      out.write("        box-shadow: 0px 0px 5px 2px black;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    img{\n");
      out.write("      width: 70px;\n");
      out.write("      height: 70px;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <div>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <img\n");
      out.write("            alt=\"Logo\"\n");
      out.write("            src=\"../images/logo.png\"\n");
      out.write("        />\n");
      out.write("        <h1>Premature</h1>\n");
      out.write("        <br />\n");
      out.write("        <h2>Baby Monitor</h2>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <form action=\"index.html\">\n");
      out.write("            <button type=\"submit\">\n");
      out.write("                <img src=\"../images/exit.png\" alt=\"LogOut\"/>\n");
      out.write("              </button>\n");
      out.write("          </form>\n");
      out.write("    <span class=\"text05\">\n");
      out.write("        <span>Patient ID: ");
      out.print(patient.getId());
      out.write("</span>\n");
      out.write("    </span>\n");
      out.write("    <span class=\"text07\">\n");
      out.write("        <span>St Mary&apos;s</span>\n");
      out.write("    </span>\n");
      out.write("    <form action=\"/\">\n");
      out.write("        <button type=\"submit\" class=\"home-btn\">\n");
      out.write("            <img src=\"../images/house.jpg\" alt=\"Home\"/>\n");
      out.write("        </button>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("    <main id=\"main-holder-1\">\n");
      out.write("        <div class=\"glucose\">\n");
      out.write("            <span class=\"text09\">\n");
      out.write("            <span>Glucose level</span>\n");
      out.write("            </span>\n");
      out.write("            <span class=\"text11\"><span>mmol</span></span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"time\">\n");
      out.write("            <span class=\"text13\">\n");
      out.write("            <span>Default time</span>\n");
      out.write("            </span>\n");
      out.write("        </div>\n");
      out.write("        <button class=\"save\">\n");
      out.write("            <span class=\"text17\"><span>Save</span></span>\n");
      out.write("        </button>\n");
      out.write("        <span class=\"text21\"><span>NEW MEASUREMENT</span></span>\n");
      out.write("    </main>\n");
      out.write("    <main id=\"main-holder-2\">\n");
      out.write("        <div class=\"comment-time\">\n");
      out.write("            <span class=\"text29\">\n");
      out.write("            <span>Default time</span>\n");
      out.write("            </span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"comment\">\n");
      out.write("            <span class=\"text23\">\n");
      out.write("            <span>Comment</span>\n");
      out.write("            </span>\n");
      out.write("        </div>\n");
      out.write("        <button class=\"savecomment\">\n");
      out.write("            <span class=\"text27\"><span>Save</span></span>\n");
      out.write("        </button>\n");
      out.write("        <span class=\"text31\"><span>NEW COMMENT</span></span>\n");
      out.write("    </main>\n");
      out.write("</body>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
