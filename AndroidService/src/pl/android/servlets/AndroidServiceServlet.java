package pl.android.servlets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.json.JSONException;
import org.json.JSONObject;
import org.tempuri.*;

public class AndroidServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AndroidServiceServlet() {
		super();
	}
	
	//post method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    System.out.println("*****************************");
	    System.out.println("******  START SERVLET  ******");
	    
	    
	    PostOfficeSoapProxy op =  new PostOfficeSoapProxy();
		
		PostOfficeSoap hello = op.getPostOfficeSoap();
		PostOfficeLocator p = new PostOfficeLocator();
		try {
			PostOfficeSoap h = p.getPostOfficeSoap();
			System.out.println(h.hello());
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String x = hello.hello();
		System.out.println("WS: "+x);
		
	    String event = request.getParameter("event"),
	     	   data = request.getParameter("data"),
	     	   method = request.getMethod(),
	     	   contentType = request.getContentType();

           if (method.equals("POST") && contentType.startsWith("application-android/json;charset=utf-8")) {
        	   
        	   
        			DataInputStream in = new DataInputStream(request.getInputStream());
               
        		//	 BufferedReader lines = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        			 
        	     //   System.out.println("event: "+lines.readLine());
        	     //   in.close();
        	

        	    try {
        	        BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        	        StringBuilder responseStrBuilder = new StringBuilder();

        	        String inputStr;
        	        while ((inputStr = streamReader.readLine()) != null)
        	            responseStrBuilder.append(inputStr);

        	        JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

        	        event = jsonObject.getString("event").toString();
        	        data = jsonObject.getString("data").toString();

        	    } catch (IOException e) {
        	        e.printStackTrace();
        	    } catch (JSONException e) {
        	        e.printStackTrace();
        	    }
           }

	 //   printJSONObject(event, data);
	    
	    //respone_area -->
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        JSONObject json = new JSONObject();
        try {
        	json.put("event", "CHECK_SERVLET");
        	json.put("data", "OK");
		
        	
		} catch (JSONException e) {
			e.printStackTrace();
		}

        out.print(json);
        out.flush();
        
	    System.out.println("*****************************");
	    System.out.println("******  CLOSE SERVLET  ******");
	    System.out.println("*****************************");
	    	    	    	   
	}
	
	
	private void printJSONObject(String event, String data) {
		int marker = 0;
		char[] dataArray = data.toCharArray();
		System.out.print("event: "+event+";\ndata "+dataArray.length+": ");
			for(int i=0; i < dataArray.length; i++) {
				if(marker < 100) {
					System.out.print(dataArray[i]);
					marker++;
				}else{
					System.out.print("\n"+dataArray[i]);
					marker=0;
				}
			}
			System.out.print("\n");
	}

	//get method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
    }
	
	
	
}
