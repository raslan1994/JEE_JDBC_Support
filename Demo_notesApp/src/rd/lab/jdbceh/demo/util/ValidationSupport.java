package rd.lab.jdbceh.demo.util;

import javax.servlet.http.HttpServletRequest;

public class ValidationSupport {
	public static String getValidString(String source,String nullValue){
		if(source == null){
			return nullValue;
		}
		
		return source;
	}
	
	public static String getValidParameter(HttpServletRequest request, String param, String nullValue){
		return getValidString(request.getParameter(param), nullValue);
	}
	
	public static String getValidParameter(HttpServletRequest request, String param){
		return getValidString(request.getParameter(param),"");
	}
}
