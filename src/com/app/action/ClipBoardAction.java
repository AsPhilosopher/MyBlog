package app.action;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipBoardAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;
	private boolean flag=false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	private  void setClipbordContents(String contents) {
		  StringSelection stringSelection = new StringSelection( contents );
		  // 系统剪贴板
		  Clipboard  clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  clipboard.setContents(stringSelection, null);
		 }
	
	public String copy() {
		setClipbordContents(request.getParameter("pic_url"));
		System.out.println(request.getParameter("pic_url")+"@@@@");
		flag = true;
		return "COPYSUCCESS";
	}
	
}
