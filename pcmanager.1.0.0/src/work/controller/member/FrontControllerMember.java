package work.controller.member;

import work.model.dao.MemberDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontControllerMember extends HttpServlet {
	// MemberDao를 객체 생성
	private MemberDao dao = new MemberDao();
	
	/**
	 * 회원관리시스템의 모든 요청을 관리하는 Controller 클래스
	 * -- 1. 요청파악 : action=0000
	 * -- 2. 요청 데이터 추출
	 * -- 3. 요청 데이터 검증
	 * -- 4. 모델에게 요청처리 의뢰
	 * -- 5. 모델에게 요청결과받아서 응답위한 결과값 설정
	 * -- 6. 응답페이지 이동 
	 * 			=> 성공
	 * 			=> 실패
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청파악 : action=0000 : getParameter("key") : String
		String action = request.getParameter("action");
		System.out.println("\n## action : " + action);
		
		switch(action) {
			case "login":
				//로그인 요청처리 메서드 호출
				login(request, response);
				break;
			case "joinSave":
				joinSave(request, response);
				break;
			case "logout":
				logout(request, response);
				break;
			case "myInfo":
				myInfo(request, response);
				break;
			case "changePassword":
				changePassword(request, response);
				break;
			case "myInfoUpdate":
				myInfoUpdate(request, response);
				break;
			case "myInfoUpdateSave":
				myInfoUpdateSave(request, response);
				break;
			case "getMemberAll":
				getMemberAll(request, response);
				break;
			case "deleteMember":
				deleteMember(request, response);
				break;
			case "updateMember":
				updateMember(request, response);
				break;
			case "updateMemberSave":
				updateMemberSave(request, response);
				break;
			default:	
		}	
		
	}

	// 관리자 :  회원 내정보 변경 저장 요청
	protected void updateMemberSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null
				&& session.getAttribute("grade") != null) {
			if (session.getAttribute("grade").equals("A")) {
				String memberId = request.getParameter("memberId");
				String memberPw = request.getParameter("memberPw");
				String memberName = request.getParameter("memberName");
				String mobile = request.getParameter("mobile");
				String email = request.getParameter("email");
				
				String entryDate = request.getParameter("entryDate");
				char grade = request.getParameter("grade").charAt(0);
				int mileage = Integer.parseInt(request.getParameter("mileage"));
				String manager = request.getParameter("manager");
				
				Member dto = new Member(memberId, memberPw, memberName, mobile, email, entryDate, grade, mileage, manager);
				dao.updateAll(dto);	// 관리자 회원정보 변경 완료
				getMemberAll(request, response); // 응답: 전체회원조회
			} else {
				request.setAttribute("message", "해당 서비스에 대한 권한이 부족합니다.");
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	// 관리자 : 회원 정보 변경 (기본변경정보 + 가입일, 등급, 마일리지, 담당자)
	protected void updateMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null
				&& session.getAttribute("grade") != null) {
				String grade = (String)session.getAttribute("grade");
				
			// 관리자회원인지 검증
			if (grade.equals("A")) {
				String memberId = request.getParameter("memberId");
				if (memberId != null && memberId.trim().length() > 0) {
					Member dto = dao.selectOne(memberId);  // 선택회원 변경위한 조회
					
					//String memberPw = dto.getMemberPw();
					//dto.setMemberPw(Utility.convertSecureString(memberPw,3));
					request.setAttribute("dto", dto);
					request.getRequestDispatcher("/updateMember.jsp").forward(request, response);
					
				} 	
			} else {
				request.setAttribute("message", "해당 서비스에 대한 권한이 부족합니다.");
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
			
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}
	
	// 관리자 : 회원탈퇴
	protected void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null
				&& session.getAttribute("grade") != null) {
				String grade = (String)session.getAttribute("grade");
				
			// 관리자회원인지 검증
			if (grade.equals("A")) {
				String memberId = request.getParameter("memberId");
				if (memberId != null && memberId.trim().length() > 0) {
					dao.delete(memberId);  // 선택회원 탈퇴처리
					getMemberAll(request, response); // 전제회원 조회
				} 	
			} else {
				request.setAttribute("message", "해당 서비스에 대한 권한이 부족합니다.");
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
			
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}
	
	// 관리자 : 전체회원조회
	protected void getMemberAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null
				&& session.getAttribute("grade") != null) {
				String grade = (String)session.getAttribute("grade");
				
			// 관리자회원인지 검증
			if (grade.equals("A")) {
				ArrayList<Member> list = dao.selectList();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/memberList.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "해당 서비스에 대한 권한이 부족합니다.");
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
			
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	// 일반/우수 회원 내정보 변경 저장 요청
	protected void myInfoUpdateSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null) {
			String memberId = (String)session.getAttribute("memberId");
			String memberPw = request.getParameter("memberPw");
			String memberName = request.getParameter("memberName");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			
			Member dto = new Member(memberId, memberPw, memberName, mobile, email);
			dao.update(dto);
			request.setAttribute("message", "내정보 변경이 완료되었습니다.");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	// 일반/우수 회원 내정보 변경위한 내정보 조회 요청
	protected void myInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null) {
			String memberId = (String)session.getAttribute("memberId");
			Member dto = dao.selectOne(memberId);
			if (dto != null) {
				//String memberPw = dto.getMemberPw();
				//dto.setMemberPw(Utility.convertSecureString(memberPw,3));
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/myInfoUpdate.jsp").forward(request, response);
			} else {
				response.sendRedirect("result.jsp");
			}
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}	
	
	protected void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null) {
			// 암호변경 : 아이디(세션), 
			// 기존암호(요청페이지 memberPw), 변경암호(요청페이지 newMemberPw)
			String memberId = (String)session.getAttribute("memberId");
			String memberPw = request.getParameter("memberPw");
			String newMemberPw = request.getParameter("newMemberPw");
			// 기존암호, 변경암호 입력유무 검증
			if (memberPw != null 
					&& newMemberPw != null
					&& memberPw.trim().length() > 0
					&& newMemberPw.trim().length() > 0) {
				int rows = dao.updatePassword(memberId, memberPw, newMemberPw);
				if (rows == 1) {
					request.setAttribute("message", "암호 변경이 완료되었습니다.");
					request.getRequestDispatcher("/result.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("message", "암호 변경이 정상적으로 이루어지 않았습니다. 다시 확인하시기 바랍니다.");
				request.getRequestDispatcher("/result.jsp").forward(request, response);
				//response.sendRedirect("/result.jsp");
			}
		} else {
			// 사용자 인증받지않은 미인증 사용자
			request.setAttribute("message", "로그인/회원가입후 이용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	
	/* 로그아웃 :
	 * 로그인 사용자(세션객체존재, 아이디 등급 설정)가 로그아웃
	 *	1. 세션객체 가져오기 : 기존세션가져오기 getSession(false)
	 *	2. 세션객체 설정 아이디 가져와서 존재하면 세션설정정보 삭제:removeAttribute(key)
	 *	3. 세션객체 설정 등급 가져와서 존재하면 세션설정정보 삭제
	 *	4. 세션객체 삭제 : invalidate()
	 *	5. 로그아웃 응답페이지 이동 : 시작페이지, 로그아웃성공응답페이지
	 *	6. 로그아웃실패(오류)
	 *		-- 로그인하지않고 로그아웃요청 : 시작페이지
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null
				&& session.getAttribute("memberId") != null
				&& session.getAttribute("grade") != null) {
			session.removeAttribute("memberId");
			session.removeAttribute("grade");
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else { 
			request.setAttribute("message", "로그인 후 사용하시기 바랍니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);		
			//response.sendRedirect("index.jsp");
		}
	}	
	
	/*
	 * 내정보조회
	 * -- 로그인 사용자의 내정보조회 : 세션에 설정되어 있는 아이디(로그인사용자)의 정보
	 * -- 1. 요청화면
	 * 		=> 회원전용 서비스 시작페이지 : result.jsp
	 * -- 2. contrller
	 * -- 3. model : service => dao (sql) : Member
	 * -- 4. controller 응답 위한 설정
	 * -- 5. 응답페이지 이동 : Member#getXxx()
	 * 		=> myInfo.jsp
	 */
	protected void myInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null 
				&& session.getAttribute("memberId") != null) {
			String memberId = (String)session.getAttribute("memberId");
			Member dto = dao.selectOne(memberId);
			if (dto != null) {
				String memberPw = dto.getMemberPw();
				dto.setMemberPw(Utility.convertSecureString(memberPw,3));
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/myInfo.jsp").forward(request, response);
			} else {
				response.sendRedirect("result.jsp");
			}
		} else {
			// 로그인하지 않은 사용자 오류 처리
			request.setAttribute("message", "회원전용 서비스 입니다. 로그인 후 사용하시기 바랍니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}	
		
	/* 회원가입 저장요청 서비스 메서드 */
	protected void joinSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n## action : joinSave()");
		// 2. 요청 데이터 추출 : join.jsp
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		System.out.println("\n## :" + memberId + ", " + memberPw + ", " 
				+ memberName + ", " + mobile + ", "
				+ email);
	}

	/* 로그인 요청 서비스 메서드
	 * -- 2. 요청 데이터 추출 : 로그인요청화면참고(login.jsp)
	 * -- 3. 요청 데이터 검증
	 * -- 4. 모델에게 요청처리 의뢰
	 * -- 5. 모델에게 요청결과받아서 응답위한 결과값 설정
	 * -- 6. 응답페이지 이동 
	 * 			=> 성공
	 * 			=> 실패
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n## action : login()");
		// 2. 요청 데이터 추출
		// 미입력 => 공백문자열 반환, parameter-name 미존재하면 null 반환
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
//		String xxx = request.getParameter("xxx");
//		System.out.println("\n## :" + memberId + ", " + memberPw);
//		System.out.println("\n## :" + memberId.length() + ", " + memberPw.length());
//		System.out.println("xxx: " + xxx);
		
		// 3. 요청 데이터 검증 : 필수항목
		if (memberId.length() > 0 && memberPw.length() > 0) {
			// 4. 모델에게 요청처리 의뢰 : 
			String grade = dao.loginCheck(memberId, memberPw);
			if (grade != null) {
				// 로그인 인증 정보를 세션객체 생성해서 설정
				HttpSession session = request.getSession(true); //
				session.setAttribute("grade", grade);
				session.setAttribute("memberId", memberId);
				
				System.out.println("controller: session.isNew() : " + session.isNew());
				System.out.println("controller: session.getId() : " + session.getId());
							
				// 5. 모델에게 요청결과받아서 응답위한 결과값 설정
				//request.setAttribute("grade", grade);
				//request.setAttribute("memberId", memberId);
				// 6. 응답페이지 이동 : 성공 : result.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
				dispatcher.forward(request, response);		
			} else {
				// 6. 응답페이지 이동 : 실패 : error.jsp
				request.setAttribute("message", "로그인 정보가 올바르지 않습니다. 다시 확인하시기 바랍니다.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);		
			}	
		} else {
			// 5. 모델에게 요청결과받아서 응답위한 결과값 설정
			request.setAttribute("message", "로그인 정보를 입력하시기 바랍니다.");
			// 6. 응답페이지 이동 : 실패 => 필수항목 데이터 미입력
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);		
		}	
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 요청에 대한 한글 인코딩 설정
		request.setCharacterEncoding("euc-kr");
		process(request, response);
	}

	
	
	
	
}

