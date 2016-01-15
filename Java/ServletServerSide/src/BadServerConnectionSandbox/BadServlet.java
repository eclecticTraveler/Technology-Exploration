//package BadServerConnectionSandbox;
//
//import org.quickconnectfamily.json.JSONInputStream;
//import org.quickconnectfamily.json.JSONOutputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.rmi.server.ExportException;
//import java.util.HashMap;
//
///**
// * Created by rome on 11/11/2015.
// */
//@WebServlet(name = "BadServlet", urlPatterns = {"/json"})
//public class BadServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       try {
//           JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
//           JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());
//
//           // ERROR : java.net.SocketException: Connection reset
//           Thread.currentThread().sleep(100000);
//
//           HashMap<String, Object> dataMap = (HashMap) inFromClient.readObject();
//
//           dataMap.put("toClient", outToClient);
//
//           String aCommand = (String) dataMap.get("command");
//
//
//       }catch (Exception e)
//       {
//           e.printStackTrace();
//       }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
