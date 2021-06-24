
package jp.dcnet.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { // ログイン成功したら、ユーザのセッションを保存する

		Object loginUser = request.getSession().getAttribute("userRole");

		if (loginUser == null) {// ログインしてない場合

			request.setAttribute("msg", "登録してください。");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		} else {
			return true;
		}
	}
}
