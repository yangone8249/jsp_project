package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;

import domain.commentVO;
import service.commentService;
import service.commentServiceImpl;


@WebServlet("/cmt/*")
public class commentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(commentController.class);
	//목적지 주소로 보내는 destPage 쓰지 않는다. (board/detail.jsp에서 처리할것이기 때문에)
	//비동기 통신으로 요청이 온곳으로 돌려보냄
	private int isOk;
	private commentService csv;
	
	
	
	
    public commentController() {
        csv = new commentServiceImpl();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//contentType은 사용하지않는다. (ajex에서 사용할 예정)
		
		//brd/list, brd/register
		//cmt/post/1,2,3....10 => 이런식으로 가져오는걸 REST API방식이라고 말한다.
		String uri = request.getRequestURI(); //requset의 URI를 가져온다.
		log.info(uri);
		String pathUri = uri.substring("/cmt/".length());
		String path = pathUri;
		String pathVar = "";
	
		if (pathUri.contains("/")){ // pathUri에서 "/" 값이 있다면 if문 참
			path = pathUri.substring(0, pathUri.lastIndexOf("/")); // /path/ 값을 출력 (마지막/는 제거한다)
			pathVar = pathUri.substring(pathUri.lastIndexOf("/")+1);// path.../숫자 값을 출력
		}
		log.info(path);
		log.info(pathVar);
		
		switch (path) {
		case "post":
			try {
				//js에서 보낸 데이터를 StringBuffer로 읽어들이는 작업.
				StringBuffer sb = new StringBuffer();
				String line="";
				BufferedReader br = request.getReader(); //댓글 객체를 br에 대입한다.
				while((line = br.readLine()) != null) { //null이 아니라면.. (값이 남아있다면 if문 참)
					sb.append(line); //sb에 버퍼를 넣는다.
				}
				log.info(">>> sb : "+sb.toString());
				
				//객체로 생성
				// JSON <-> text 변경
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject)parser.parse(sb.toString());//문자열을 json으로 변경한다.
				
				int bno = Integer.parseInt(jsonObj.get("bno").toString()); //json객체의 bno를 정수로 변경
				log.info("bno : " +bno);
				String writer = jsonObj.get("writer").toString();//json객체의 writer를 문자열로 변경
				String content = jsonObj.get("content").toString(); //json객체의 content를 문자열로 변경
				commentVO cvo = new commentVO(bno, writer, content);
				log.info(">>>> cvo : "+cvo);
				isOk = csv.post(cvo);
				log.info(">>> post : "+(isOk>0 ? "Ok": "Fail"));
				//결과 전송
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				log.info(">>> comment post > error");
				e.printStackTrace();
			}
			
			break;
		case "list":
			try {
				int bno = Integer.parseInt(pathVar);
				List<commentVO> list = csv.getList(bno); //여기로 받은 리스트는 java의 객체 타입이다.
				log.info(">>> Comment List : DB ok"); 
				
				//json 형태로 변환해서 printWriter
				//list를 가져오기때문에 JsonObject는 배열로 생성한다.
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				for(int i=0; i<list.size(); i++) {
					jsonObjArr[i] = new JSONObject(); //key : value형태로 저장
					jsonObjArr[i].put("cno", list.get(i).getCno());
					jsonObjArr[i].put("bno", list.get(i).getBno());
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("regdate", list.get(i).getRegdate()); 
					
					jsonObjList.add(jsonObjArr[i]); //jsonObjArr를 jsonObjList에 저장한다.
				}
				log.info(">>> JsonObjList : "+jsonObjList);
				String jsonData = jsonObjList.toJSONString();
				log.info(">>> JsonData : "+jsonData);
				
				
				PrintWriter out = response.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				log.info(">>> comment List : error");
				e.printStackTrace();
			}
			
			break;
		case "remove":
			try {
				int cno = Integer.parseInt(request.getParameter("cnoVal")); //쿼리스트링 방식
				log.info("cno : "+cno);
				
				isOk = csv.remove(cno);
				log.info("remove isOk : " + ((isOk>0) ? "Ok":"Fail"));
				System.out.print(isOk);
				PrintWriter out = response.getWriter();
			} catch (Exception e) {
				log.info("remove error~!!");
				e.printStackTrace();
			}
			
			break;
		case "modify":
			try {
				//js에서 보낸 데이터를 StringBuffer로 읽어들이는 작업.
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = request.getReader(); //댓글 객체를 br에 대입한다.
				while((line = br.readLine()) != null) { //null이 아니라면.. (값이 남아있다면 if문 참)
					sb.append(line); //sb에 버퍼를 넣는다.
				}
				log.info(">>> sb : "+sb.toString());
				
				//객체로 생성
				// JSON <-> text 변경
				JSONParser parser = new JSONParser();//String을 Json으로 바꿔주는 객체가 JSONParser이다.
				JSONObject jsonObj = (JSONObject)parser.parse(sb.toString());//객체를 실제 Object로 변경해주는 객체 JSONObject
				
				int cno = Integer.parseInt(jsonObj.get("cno").toString()); //json객체의 bno를 정수로 변경
				log.info("cno : " +cno);
				String content = jsonObj.get("content").toString(); //json객체의 content를 문자열로 변경
				commentVO cvo = new commentVO(cno, content);
				log.info(">>>> cvo : "+cvo);
				isOk = csv.update(cvo);
				log.info(">>> update : "+(isOk>0 ? "Ok": "Fail"));
				//결과 전송
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
				
			} catch (Exception e) {
				log.info("modify error~!!");
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}

}
