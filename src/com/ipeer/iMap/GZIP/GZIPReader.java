package com.ipeer.iMap.GZIP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public class GZIPReader {

	private InputStream in;
	private OutputStream out;
	
	public GZIPReader(File in, File out) throws IOException {
		this.in = new FileInputStream(in);
		this.out = new FileOutputStream(out);
	}
	
	public void unzip() throws IOException {
		try {
			System.out.println("DECOMPRESSING...");
			this.in = new GZIPInputStream(this.in);
			byte[] buffer = new byte[65536];
			int noRead;
			if ((noRead = this.in.read(buffer)) != -1)
				this.out.write(buffer, 0, noRead);
		}
		finally {
			System.out.println("I HAVE DONE AS YOU ASKED!");
			this.in.close();
		}
	}
	
}
