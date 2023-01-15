/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2023-01-15 19:57:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Patient;
import models.GlucoseLevel;
import models.Comment;
import models.User;
import org.json.JSONObject;

public final class data_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("models.Comment");
    _jspx_imports_classes.add("org.json.JSONObject");
    _jspx_imports_classes.add("models.User");
    _jspx_imports_classes.add("models.Patient");
    _jspx_imports_classes.add("models.GlucoseLevel");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Patient patient = (Patient)request.getAttribute("patient");
    User user = (User)request.getSession().getAttribute("user");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/data.css\">\n");
      out.write("    <script defer src=\"../js/data.js\"></script>\n");
      out.write("    <div>\n");
      out.write("        <canvas id=\"myChart\"></canvas>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        button{\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            appearance: none;\n");
      out.write("            background-color: inherit;\n");
      out.write("            margin-left:10px;\n");
      out.write("            margin-top:20px;\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            box-shadow: 0px 0px 5px 2px black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        img{\n");
      out.write("            width: 70px;\n");
      out.write("            height: 70px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <img\n");
      out.write("                alt=\"Logo\"\n");
      out.write("                src=\"../images/logo.png\"\n");
      out.write("        />\n");
      out.write("        <h1>Premature</h1>\n");
      out.write("        <br />\n");
      out.write("        <h2>Baby Monitor</h2>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <form action=\"/logout\">\n");
      out.write("            <button type=\"submit\">\n");
      out.write("                <img src=\"../images/exit.png\" alt=\"LogOut\"/>\n");
      out.write("            </button>\n");
      out.write("        </form>\n");
      out.write("        <span class=\"text05\">\n");
      out.write("      <span>Patient ID: ");
      out.print(patient.getId());
      out.write("</span>\n");
      out.write("  </span>\n");
      out.write("        <span class=\"text07\">\n");
      out.write("      <span>");
      out.print(patient.getHospital());
      out.write("</span>\n");
      out.write("  </span>\n");
      out.write("        <form action=\"/\">\n");
      out.write("            <button type=\"submit\" class=\"home-btn\">\n");
      out.write("                <img src=\"../images/house.jpg\" alt=\"Home\"/>\n");
      out.write("            </button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <canvas id=\"myGraph\" style=\"width: 35%; height: auto;\">\n");
      out.write("        <script>\n");
      out.write("           let glucoseLevels = ");
      out.print(JSONObject.valueToString(patient.getGlucoseLevels()));
      out.write("\n");
      out.write("           let glucoseLevelsHP = ");
      out.print(JSONObject.valueToString(patient.getGlucoseLevelsHP()));
      out.write("\n");
      out.write("           let comments = ");
      out.print(JSONObject.valueToString(patient.getComments()));
      out.write("\n");
      out.write("           let upperThreshold = ");
      out.print(patient.getUpperThreshold());
      out.write("\n");
      out.write("           let lowerThreshold = ");
      out.print(patient.getLowerThreshold());
      out.write("\n");
      out.write("\n");
      out.write("           /* new Chart(\"MyGraph\", {\n");
      out.write("                type: 'line',\n");
      out.write("                data: {\n");
      out.write("                    labels: ['00:00', '00:10', '00:20', '00:30', '00:40', '00:50', '01:00', '01:10', '01:20', '01:30'],\n");
      out.write("                    datasets: [{\n");
      out.write("                        label: 'Concentration',\n");
      out.write("                        data: [12, 19, 3, 5, 2, 3, 20, 15, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100],\n");
      out.write("                        backgroundColor: 'rgba(255, 99, 132, 0.2)',\n");
      out.write("                        borderColor: 'rgba(255, 99, 132, 1)',\n");
      out.write("                        borderWidth: 1\n");
      out.write("                    }]\n");
      out.write("                },\n");
      out.write("                options: {\n");
      out.write("                    scales: {\n");
      out.write("                        xAxes: [{\n");
      out.write("                            type: 'time',\n");
      out.write("                            time: {\n");
      out.write("                                unit: 'minute',\n");
      out.write("                                unitStepSize: 15,\n");
      out.write("                                min: '00:00',\n");
      out.write("                                max: '24:00',\n");
      out.write("                                displayFormats: {\n");
      out.write("                                    'minute': 'HH:mm'\n");
      out.write("                                }\n");
      out.write("                            },\n");
      out.write("                            gridLines: {\n");
      out.write("                                display: false\n");
      out.write("                            }\n");
      out.write("                        }],\n");
      out.write("                        yAxes: [{\n");
      out.write("                            scaleLabel: {\n");
      out.write("                                display: true,\n");
      out.write("                                labelString: 'Concentration'\n");
      out.write("                            },\n");
      out.write("                            ticks: {\n");
      out.write("                                min: 0,\n");
      out.write("                                max: 100,\n");
      out.write("                                stepSize: 10\n");
      out.write("                            }\n");
      out.write("                        }]\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });*/\n");
      out.write("            new Chart(\"myGraph\", {\n");
      out.write("                type: \"line\",\n");
      out.write("                data: {\n");
      out.write("                    datasets: [\n");
      out.write("                    {\n");
      out.write("                        data: glucoseLevels.map(g => ({x: g.timestamp, y: g.value})),\n");
      out.write("                        label: 'A',\n");
      out.write("                        yAxisID: 'A',\n");
      out.write("                        borderColor: \"green\",\n");
      out.write("                        fill: false\n");
      out.write("                    }, \n");
      out.write("                    {\n");
      out.write("                        data: glucoseLevelsHP.map(g => ({x: g.timestamp, y: g.value})),\n");
      out.write("                        label: 'B',\n");
      out.write("                        yAxisID: 'B',\n");
      out.write("                        borderColor: \"orange\",\n");
      out.write("                        fill: false\n");
      out.write("                    }]\n");
      out.write("                },\n");
      out.write("                options: {\n");
      out.write("                    legend: {display: false}\n");
      out.write("                },\n");
      out.write("                options: {\n");
      out.write("                    scales: {\n");
      out.write("                        yAxes: [{\n");
      out.write("                            id: 'A',\n");
      out.write("                            type: 'linear',\n");
      out.write("                            position: 'left',\n");
      out.write("                        }, {\n");
      out.write("                            id: 'B',\n");
      out.write("                            type: 'linear',\n");
      out.write("                            position: 'right',\n");
      out.write("                            ticks: {\n");
      out.write("                                max: 100,\n");
      out.write("                                min: 0\n");
      out.write("                            }\n");
      out.write("                        }],\n");
      out.write("                        xAxes: [{\n");
      out.write("                            type: 'time',\n");
      out.write("                            time: {\n");
      out.write("                                unit: 'minute',\n");
      out.write("                                unitStepSize: 15,\n");
      out.write("                                min: '00:00',\n");
      out.write("                                max: '24:00',\n");
      out.write("                                displayFormats: {\n");
      out.write("                                    'minute': 'HH:mm'\n");
      out.write("                                }\n");
      out.write("                            },\n");
      out.write("                            gridLines: {\n");
      out.write("                                display: false\n");
      out.write("                            }\n");
      out.write("                        }],\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </canvas>\n");
      out.write("    <div id=\"comments-frame\">\n");
      out.write("        <h2>Comments</h2>\n");
      out.write("        <div id=\"comments-list\">\n");
      out.write("            ");

            for(Comment comment : patient.getComments()) {          
            
      out.write("\n");
      out.write("            <span>Time: ");
      out.print(comment.getTimestamp());
      out.write("</span>\n");
      out.write("            <br/>\n");
      out.write("            <span>");
      out.print(comment.getValue());
      out.write("</span>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            ");

            }    
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("   ");

    if(user.getRole().equals("Doctor")) {
    
      out.write("\n");
      out.write("    <form action=\"/patient/thresholds\">\n");
      out.write("        <input name=\"id\" value=\"");
      out.print(patient.getId());
      out.write("\" type=\"hidden\"/>\n");
      out.write("        <button class=\"edit-thresh\">\n");
      out.write("            <span class=\"text19\"><span>Edit threshold</span></span>\n");
      out.write("        </button>\n");
      out.write("    </form>\n");
      out.write("    %>\n");
      out.write("    ");

    }
    
      out.write("\n");
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
