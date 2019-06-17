package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      //사용자 아이디를 파라미터로 부터 확인 
	      String userId = request.getParameter("userId");
	      
	      
	       // 사용자 정보를 조회 
	      UserVO userVo = userService.getUser(userId);
	      
	      //path정보로 file을 읽어온다 
	      ServletOutputStream sos=  response.getOutputStream();
	      
	      String filePath=null;
	      FileInputStream fis = null;
	      
	      
	      //사용자가 업로드한 파일이 존재할경우
	      if(userVo.getPath()!=null){
	         filePath=userVo.getPath();
	      }
	      
	      //사용자가 업로드한 파일이 존재하지 않을경우
	      
	      else
	         filePath= getServletContext().getRealPath("/img/no_image.gif");
	         
	      
	      File file = new File(filePath);
	      fis = new FileInputStream(file);
	      byte[] buffer = new byte[512];
	      
	      
	      while( fis.read(buffer ,0 ,512) !=-1){
	         sos.write(buffer);
	      }
	      
	      
	      
	      fis.close();
	      sos.close();
	      
	      
	      //PATH 정보로  file을 읽어 들여서 
	      //response 객체에 스트림으로 써준다 
	      //request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		
		
		
	
	}


}
