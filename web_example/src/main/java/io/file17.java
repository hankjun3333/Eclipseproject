package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//flush close 필수!!
public class file17 {

	public static void main(String[] args) {
		try {
			data14 d = new data14();
			d.abc();
		}
		catch(Exception e) {
			System.out.println();
		}
	}

}
class data14{
	public void abc() throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st = null;
		//System.out.println(bf.readLine());
		int n = Integer.parseInt(bf.readLine());
		int w =0;
		while(w<n) {
			st = new String(bf.readLine());
			int a = Integer.parseInt(st);
			int b = Integer.parseInt(st);
			int sum = a+b;
			bw.write(sum);
			bw.flush();
			w++;
		}
		bw.close();
		bf.close();

	}
}
