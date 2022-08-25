package HadoopProject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class SeaLevel {
	static { 
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory()); 
	}
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		InputStream in = null; 
		
		while (true){
			
			System.out.println("----------------------------");
			System.out.println("1901 ~ 1950년 해수면 지표");
			System.out.println("1. 년도별 최고해수면");
			System.out.println("2. 년도별 최저해수면");
			System.out.println("3. 평균 해수면");
			System.out.println("4. 프로그램 종료");
			System.out.println("----------------------------");
			System.out.println(">");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == 1 ) {
				
				String str = "http://192.168.204.128:50070/webhdfs/v1/HighSeaLevel?op=OPEN";
	               
	               try {
	               
	                  in = new URL(str).openStream(); 
	                  IOUtils.copyBytes(in, System.out, 4096, false); 
	                  } 
	                  finally { 
	                     IOUtils.closeStream(in); 
	                  }

			}
			else if (choice == 2) {
				
				String str1 = "http://192.168.204.128:50070/webhdfs/v1/LowSeaLevel?op=OPEN";
			      
	            try {
	             
	               in = new URL(str1).openStream(); 
	               IOUtils.copyBytes(in, System.out, 4096, false); 
	               } 
	                  finally { 
	                     IOUtils.closeStream(in); 
	                  }
	             

			}
			
			else if (choice == 3) {
				
				String str2 = "http://192.168.204.128:50070/webhdfs/v1/balance?op=OPEN";
	            
	            try {
	             
	               in = new URL(str2).openStream(); 
	               IOUtils.copyBytes(in, System.out, 4096, false); 
	               } 
	                  finally { 
	                     IOUtils.closeStream(in); 
	                  }
	               

			}
			
			else if (choice == 4) {
				
				 System.out.println("프로그램 종료");
		            System.out.println("안녕히계세요.");
		            System.exit(0);

			}
			
			else {
				System.out.println("다시 입력해주세요.");
			}
		}
		
	}
}
