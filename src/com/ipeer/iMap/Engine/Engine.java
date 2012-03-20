package com.ipeer.iMap.Engine;

import java.io.File;
import java.io.IOException;

import com.ipeer.iMap.GZIP.GZIPReader;
import com.ipeer.iMap.ZLIB.ZLIBReader;

public class Engine {

	private static File fa, fb;
	
	public static void main(String[] args) {
		if (args.length == 2) {
			String a = args[0];
			String b = args[1];
			System.out.println(a+", "+b);
			fa = new File(a);
			fb = new File(b);
			fb.mkdirs();
		}
		else {
			System.out.println("INVALID ARGUMENTS!");
			System.exit(0);
		}

		try {
			GZIPReader g = new GZIPReader(fa, fb);
			g.decompress();
		}
		catch (IOException i) {
			System.out.println("Error: "+i.getMessage()+"\nAttempting to decompress using Zlib");
			if (i.getMessage().contains("Not in GZIP format"))
				try {
					new ZLIBReader(fa, fb).decompress();
				} catch (Exception e) {
					System.out.println("Can't do that for ye.");
					e.printStackTrace();
				}
		}
		catch (Exception e) {
			System.out.println("I CANAE DO EHT CAPT'N!");
			e.printStackTrace();
		}
	}

}
