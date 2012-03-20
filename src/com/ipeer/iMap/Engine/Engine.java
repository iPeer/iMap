package com.ipeer.iMap.Engine;

import java.io.File;
import java.io.IOException;

import com.ipeer.iMap.GZIP.GZIPReader;

public class Engine {

	private static File fa, fb;
	
	public static void main(String[] args) {
		if (args.length == 2) {
			String a = args[0];
			String b = args[1];
			System.out.println(a+", "+b);
			fa = new File(a);
			fb = new File(b);
			try {
				fb.createNewFile();
			} catch (IOException e) {
				System.out.println("Can't create directories!");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("INVALID ARGUMENTS!");
			System.exit(0);
		}

		try {
			GZIPReader g = new GZIPReader(fa, fb);
			g.unzip();
		}
		catch (Exception e) {
			System.out.println("I CANAE DO EHT CAPT'N!");
			e.printStackTrace();
		}
	}

}
