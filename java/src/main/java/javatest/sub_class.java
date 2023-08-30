package javatest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class sub_class {

}
class timezone{
	SimpleDateFormat date = null;
	
	String now_time(int call) {
		Date today = new Date();
		if(call==1) {
			this.date = new SimpleDateFormat("yyyy-MM-dd");
		}
		else if(call ==2) {
			this.date = new SimpleDateFormat("H:m:ss");
		}
		else if(call ==3) {
			this.date = new SimpleDateFormat("yyyy-MM-dd H:m:ss");
		}
		
		String result = date.format(today);
		return result;
	}
}