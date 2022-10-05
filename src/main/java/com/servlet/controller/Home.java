package com.servlet.controller;


import com.servlet.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "home", urlPatterns = {"/home"})
public class Home  extends HttpServlet {

    List<Product> productList = new ArrayList<Product>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product pro = new Product();
        pro.setTenSanPham(req.getParameter("tensanpham"));
        pro.setSoLuong(Integer.parseInt(req.getParameter("soluong")));
        pro.setGiaBan(Float.parseFloat(req.getParameter("giaban")));
        productList.add(pro);
        req.setAttribute("productList",productList );
        req.getRequestDispatcher("/webapp/list.jsp").forward(req, resp);
    }


}
