package Practice.Lesson.IOpackage.Network.Basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP : " + local.getHostAddress());
			
			
			InetAddress[ ] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress inetAddress : iaArr) {
				System.out.println("naver IP : " + inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {	}
		/*
		 * naver IP : 223.130.195.200
		 * naver IP : 223.130.195.95
		 */
		
		
	}

}
 