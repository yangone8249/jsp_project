package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import domain.memberVO;
import service.memberService;
import service.memberServiceImpl;


@WebServlet("/mem/*")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(memberController.class);
	private RequestDispatcher rdp;
	private memberService msv;
	private String destPage;	
	private String id;
	private String password;
	private String email;
	private int age;
	private memberVO mvo = new memberVO();
	
    public memberController() {
    	msv = new memberServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		log.info(">>> uri : "+uri);
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : "+path);
		
		switch (path) {
		case "signUp":
			destPage = "/member/signUp.jsp";
			break;
		case "join":
			id = request.getParameter("id");
			log.info(id);
			password = request.getParameter("password");
			email = request.getParameter("email");
			age = Integer.parseInt(request.getParameter("age"));
			mvo = new memberVO(id,password,email,age);
			msv.insert(mvo);
			
			destPage = "/";
			break;
		case "signIn":
			destPage = "/member/signIn.jsp";
			break;
		case "login":
			
			id = request.getParameter("id");
			password = request.getParameter("password");
			
			mvo = new memberVO(id, password);
			int loginSync = msv.search(mvo); // DB에 등록된 id,pw값을 비교하기위해 search 메서드 실행
			
			memberVO findmvo = msv.findMvo(mvo); // session에 memberVO객체를 대입하기위해 findmvo 메서드 실행
			System.out.println(loginSync);
			if(loginSync == 1) {
				log.info("DB에 값찾음. \n 로그인 되었습니다.");
				HttpSession ses = request.getSession(); // 세션가져오기, 연결된 세션이 없다면 새로 생성
				ses.setAttribute("ses", findmvo); //"ses"변수명에 로그인 객체 대입
				ses.setMaxInactiveInterval(10*60);// 로그인 유지 시간(초단위)

			}else if(loginSync == 0){
				log.info("DB에 값없음. \n 로그인실패.");
				request.setAttribute("loginAccess", 1);
			}
			
			destPage = "/";
			break;
		case "index":

			destPage = "/";
			break;
		case "logout":
			HttpSession ses = request.getSession();
			ses.invalidate();
			destPage ="/";
			break;
		case "list":
			
			List<memberVO> list = msv.list();
			request.setAttribute("list", list);
			
			destPage = "/member/list.jsp";
			break;
		case "remove":
			System.out.println("remove : "+request.getParameter("id"));
			msv.remove(request.getParameter("id"));
			ses = request.getSession();
			ses.invalidate();
			destPage = "/";
			break;
		default:
			break;
		}
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		service(request, response);
	}

}
