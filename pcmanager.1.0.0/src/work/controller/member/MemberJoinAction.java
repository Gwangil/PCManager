package work.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dao.MemberDao;
import work.model.dto.Member;

public class MemberJoinAction implements Action
{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("euc-kr"); // 인코딩
		
		ActionForward forward = new ActionForward();
		
		MemberDao dao = new MemberDao();
		
		// 입력된 정보를 자바빈에 세팅한다.
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));;
		member.setBirthyy(request.getParameter("birthyy"));
		member.setBirthmm(request.getParameterValues("birthmm")[0]);
		member.setBirthdd(request.getParameter("birthdd"));
		member.setMail1(request.getParameter("mail1"));
		member.setMail2(request.getParameterValues("mail2")[0]);
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		
		// 회원가입 실행
		dao.insertMember(member);
		
		// 가입성공
		forward.setRedirect(true);
   		forward.setNextPath("Result.do");
		
   		// 가입성공 메시지를 세션에 담는다.
   		request.getSession().setAttribute("msg", "1");
   		
		return forward;
	}
}
