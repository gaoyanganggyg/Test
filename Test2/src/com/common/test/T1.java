package com.common.test;

import java.io.File;
import java.util.concurrent.Executors;

public class T1 {
	public static void main(String[] args) {
//		Executors.newSingleThreadScheduledExecutor();

		File file = new File("E:/[世界八十宝藏双语]BBC.Around.the.World.in.80.Treasures.2005.DUALAUDiO.DVDRiP.X264.iNT-KiSS");
		if(file.exists()){
			for (File temp : file.listFiles()) {
				System.out.println(temp.getName());
			}
		}
	}
}
