package com.mvc.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FdfsUtil {
	private void recordUploadFileInfo(String[] fileIds, String upFileName) {
		String fileIdsFilePath = "e:/fileId.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileIdsFilePath, true);
			fw.append(fileIds[0] + " " + fileIds[1] + " " + upFileName);
			fw.append("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String[] upload(String conf_filename, String local_filename, String upfileName) {
		String[] fileIds = null;
		try {
			ClientGlobal.init(conf_filename);

			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;

			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			NameValuePair nvp[] = new NameValuePair[] { new NameValuePair("age", "18"),
					new NameValuePair("sex", "male") };
			fileIds = storageClient.upload_file(local_filename, null, nvp);
			recordUploadFileInfo(fileIds, upfileName);
			// System.out.println(fileIds.length);
			// System.out.println("组名：" + fileIds[0]);
			// System.out.println("路径: " + fileIds[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return fileIds;
	}

	public void download(String conf_filename, String[] fileIds) {
		try {

			ClientGlobal.init(conf_filename);

			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;

			StorageClient storageClient = new StorageClient(trackerServer, storageServer);

			if (fileIds.length < 3)
				throw new Exception("fileIds错误");
			String groupName = fileIds[0];
			String upPath = fileIds[1];
			String fileName = fileIds[2];

			byte[] b = storageClient.download_file(groupName, upPath);
			System.out.println(b);
			IOUtils.write(b, new FileOutputStream("E:/" + UUID.randomUUID().toString() + "-" + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getInfo(String conf_filename, String[] fileIds) {
		try {
			ClientGlobal.init(conf_filename);

			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;

			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			FileInfo fi = storageClient.get_file_info(fileIds[0], fileIds[1]);
			System.out.println(fi.getSourceIpAddr());
			System.out.println(fi.getFileSize());
			System.out.println(fi.getCreateTimestamp());
			System.out.println(fi.getCrc32());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "src/";
		String confPath = "conf/";
		String confFileName = "fdfs_client.conf";
		String upFileName = "test.png";

		String conf_filename = confPath + confFileName;
		String local_filename = filePath + upFileName;

		FdfsUtil fdfsUtil = new FdfsUtil();
		String[] fileIds = fdfsUtil.upload(conf_filename, local_filename, upFileName);

		// download
		// fdfsUtil.testDownload(conf_filename, fileIds);
		fdfsUtil.getInfo(conf_filename, fileIds);
	}
}
