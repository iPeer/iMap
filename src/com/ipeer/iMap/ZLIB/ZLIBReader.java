package com.ipeer.iMap.ZLIB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterInputStream;

public class ZLIBReader {

	private File infile, outfile;
	
	public ZLIBReader(File a, File b) {
		this.infile = a;
		this.outfile = b;
	}
	
	public void decompress() throws IOException {
		OutputStream out = new FileOutputStream(this.outfile);
		InputStream in = new InflaterInputStream(new FileInputStream(this.infile));
		byte[] buffer = new byte[1000];
		int len;
		while ((len = in.read()) != -1)
			out.write(buffer, 0, len);
		in.close();
		out.close();
	}
	
}
