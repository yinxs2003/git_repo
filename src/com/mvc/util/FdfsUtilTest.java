package com.mvc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class FdfsUtilTest {
	private FdfsUtil fdfsUtil = new FdfsUtil();
	private String filePath = "src/";
	private String confPath = "conf/";
	private String confFileName = "fdfs_client.conf";
	private String upFileName = "test.png";

	// client配置文件位置
	private String conf_filename = confPath + confFileName;

	// 要被上传文件的位置
	private String local_filename = filePath + upFileName;

	// 文件下载到本地的位置
	private String fileIdsFilePath = "e:/fileId.txt";

	@Test
	public void testUpload() {
		String[] fileIds = fdfsUtil.upload(conf_filename, local_filename, upFileName);
		Assert.assertNotNull(fileIds);
	}

	@Test
	public void testDownload() {
		FileInputStream fis;
		BufferedReader reader = null;
		String str = null;
		ArrayList<String[]> fileIds = new ArrayList<String[]>();
		try {
			fis = new FileInputStream(new File(fileIdsFilePath));
			reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

			while (null != (str = reader.readLine())) {
				fileIds.add(str.split(" "));
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// fileIds: group1 M00/00/00/rBsMQ1chWvOAcsgPAABFapaYBmE693.png test.png

		for (String[] fileId : fileIds)
			fdfsUtil.download(conf_filename, fileId);
	}

	@Test
	public void testGetInfo() {
		FileInputStream fis;
		BufferedReader reader = null;
		String str = null;
		ArrayList<String[]> fileIds = new ArrayList<String[]>();
		try {
			fis = new FileInputStream(new File(fileIdsFilePath));
			reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

			while (null != (str = reader.readLine())) {
				fileIds.add(str.split(" "));
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (String[] fileId : fileIds) {
			fdfsUtil.getInfo(conf_filename, fileId);
		}
	}
}
