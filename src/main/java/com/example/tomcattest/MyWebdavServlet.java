package com.example.tomcattest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.catalina.servlets.WebdavServlet;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@WebServlet("/MyWebdavServlet")
@MultipartConfig
public class MyWebdavServlet extends WebdavServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("helloooo");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.doGet(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.doPost(request, response);
//        System.out.println("posted");
//        String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        System.out.println(collect);

        try {
            PrintWriter out = response.getWriter();

            File f = new File(this.getServletContext().getRealPath("/data"));
            String savePath = f.getPath();
            savePath = savePath.replace("%20", " ");
            savePath = savePath.replace("build", "");
            String fileName = "";

            System.out.println(request.getParts());

            for (Part part : request.getParts()) {
                fileName = extractFileName(part);
                fileName = fileName.replace(" ", "");
                fileName = fileName.replace("-", "");
                fileName = fileName.replace(":", "");

                File file = new File(savePath + "/" + fileName);
                if (file.exists()) {
                    String fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
                    String ext = FilenameUtils.getExtension(fileName);
                    fileName = fileNameWithOutExt +"_" + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date())
                            + File.separator + ext;
                    part.write(savePath + File.separator + fileName);
                } else {
                    part.write(savePath + File.separator + fileName);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }




}
