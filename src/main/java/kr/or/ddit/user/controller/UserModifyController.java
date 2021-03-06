package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024*1024*3, maxRequestSize = 1024*1024*15)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserModifyController.class);
	
	IuserService userService ;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
    String userId=null;
	//사용자 수정 화면 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userId = request.getParameter("userId");
		UserVO user = userService.getUser(userId);
		request.setAttribute("userVo", user);
		
		
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String  name    = request.getParameter("name");
		String  alias   = request.getParameter("alias");
		String  addr1   = request.getParameter("addr1");
		String  addr2   = request.getParameter("addr2");
		String  zipcd   = request.getParameter("zipcd");
		String  birth   = request.getParameter("birth");
		
		//사용자가 보낸 평균 비밀번호 데이터
		String  pass    = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userVo=null;
		try {
			userVo = new UserVO(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Part profile = request.getPart("profile");
		
		if(profile.getSize() > 0) {
			
			String contentDisposition = profile.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);
			
			String uploadPath = PartUtil.getUpLoadPath();
			File uploadFolder = new File(uploadPath);
			
			if(uploadFolder.exists()) {
				//파일 디스크에 쓰기
				String filePath =  uploadPath + File.separator + UUID.randomUUID().toString() +  ext;
				userVo.setPath(filePath);
				userVo.setFilename(filename);
				
				profile.write(filePath);
				profile.delete(); 
			}
			
		}
		
		
		
		int updatecnt = userService.updateUser(userVo);
		
		if(updatecnt != 0) {
		
			response.sendRedirect(request.getContextPath() + "/userPagingList");
			
		}
		
		
	}

}
