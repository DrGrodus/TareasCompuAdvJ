/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.example.calculos.triangulo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eber
 */
//@WebFilter(filterName = "ReceptorSuma"
//        , urlPatterns = {"/*.java"}
//        , dispatcherTypes = {DispatcherType.REQUEST})
public class ReceptorSuma extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReceptorSuma</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReceptorSuma at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("Resultado.jsp");
        String base = request.getParameter("campo_Base");
        String altura = request.getParameter("campo_Altura");

        Validar(request, response, base, altura);

        if (request.getAttribute("flag") != null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            Cookie ck = new Cookie("campo_Base", base);
            response.addCookie(ck);
            ck = new Cookie("campo_Altura", altura);
            response.addCookie(ck);

            triangulo tri = new triangulo(base, altura);
            tri.OperarArea();
            double area = tri.getArea();
            request.setAttribute("area", area);
            ck = new Cookie("area", Double.toString(area));
            response.addCookie(ck);

            tri.OperarPerimetro();
            double perimetro = tri.getPerimetro();
            request.setAttribute("perimetro", perimetro);
            ck = new Cookie("perimetro", Double.toString(perimetro));
            response.addCookie(ck);

            view.forward(request, response);
        }

    }

    private void Validar(ServletRequest request, ServletResponse response,
            String base, String altura)
            throws IOException, ServletException {
        if (base != null && altura != null) {
            double numBase = Double.parseDouble(base);
            double numAltu = Double.parseDouble(altura);
            if (numBase < 0 || numAltu < 0) {
                request.setAttribute("flag", 1);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
