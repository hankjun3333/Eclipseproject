package sp1;

//module getter,setter
public class userdata {
	String mid = null;
	String mname = null;
	//setter
	public userdata(String data1, String data2) {
		this.mid = data1;
		this.mname=data2;
	}
	//getter : return 있는것!
	public String getMid() {
		return mid;
	}
	public String getMname() {
		return mname;
	}

	

}
