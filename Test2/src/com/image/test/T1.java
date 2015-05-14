package com.image.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.awt.image.JPEGImageDecoder;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class T1 {
	public static void main(String[] args) {
		FileOutputStream out = null ;
		
		try {
			File file = new File("D:/MyEclipse_work/SQ/WebRoot/uploadImg/551e4c18Na3115135.jpg");
			
			BufferedImage image = javax.imageio.ImageIO.read(file);
			
			BufferedImage tag = new BufferedImage(400, 440, BufferedImage.TYPE_INT_RGB);
			
			tag.getGraphics().drawImage(image.getScaledInstance(400, 440 ,java.awt.Image.SCALE_SMOOTH), 0, 0, null);
			
			out = new FileOutputStream("D:/MyEclipse_work/SQ/WebRoot/uploadImg/551e4c18Na31151351.jpg");
			
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			
			encoder.encode(tag);
			
			System.out.println("success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
