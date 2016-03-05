<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String images = request.getContextPath() + "/images";
	session.setAttribute("images", images);
%>
