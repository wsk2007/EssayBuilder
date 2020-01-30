package org.wsk.EssayBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;


public class Download {
	public final static boolean DEBUG = true; // ������
	private static int BUFFER_SIZE = 10240; // ��������С(������Խ�����ص�Խ��,����Ҫ�����Լ��ķ���������)
	private Vector vDownLoad = new Vector(); // URL�б�
	private Vector vFileList = new Vector(); // ���غ�ı����ļ����б�
 

 
	/**
	 * ��������б�
	 */
	public void resetList() {
		vDownLoad.clear();
		vFileList.clear();
	}
 
	/**
	 * ���������б���
	 * 
	 * @param url
	 *            String
	 * @param filename
	 *            String
	 */
 
	public void addItem(String url, String filename) {
		vDownLoad.add(url);
		vFileList.add(filename);
	}
 
	/**
	 * �����б�������Դ
	 */
	public void downLoadByList() {
		String url = null;
		String filename = null;
 
		// ���б�˳�򱣴���Դ
		for (int i = 0; i < vDownLoad.size(); i++) {
			url = (String) vDownLoad.get(i);
			filename = (String) vFileList.get(i);
 
			try {
				saveToFile(url, filename);
			} catch (IOException err) {
				if (DEBUG) {
					System.out.println("��Դ[" + url + "]����ʧ��!!!");
				}
			}
		}
 
		if (DEBUG) {
			System.out.println("�������!!!");
		}
	}
 
	/**
	 * ��HTTP��Դ���Ϊ�ļ�
	 * 
	 * @param destUrl
	 *            String
	 * @param fileName
	 *            String
	 * @throws Exception
	 */
	public void saveToFile(String destUrl, String fileName) throws IOException {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
 
		// ��������
		url = new URL(destUrl);
		httpUrl = (HttpURLConnection) url.openConnection();
		// ����ָ������Դ

		httpUrl.connect();
		// ��ȡ����������
		bis = new BufferedInputStream(httpUrl.getInputStream());
		// �����ļ�
		fos = new FileOutputStream(fileName);
 
		if (this.DEBUG)
			System.out.println("���ڻ�ȡ����[" + destUrl + "]������...\n���䱣��Ϊ�ļ�["
					+ fileName + "]");
		// �����ļ�
		while ((size = bis.read(buf)) != -1)
			fos.write(buf, 0, size);
 
		fos.close();
		bis.close();
		httpUrl.disconnect();
	}
 
	/**
	 * ��HTTP��Դ���Ϊ�ļ�
	 * 
	 * @param destUrl
	 *            String
	 * @param fileName
	 *            String
	 * @throws Exception
	 */
	public void saveToFile2(String destUrl, String fileName) throws IOException {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		// ��������
		url = new URL(destUrl);
		httpUrl = (HttpURLConnection) url.openConnection();
 
		// String authString = "username" + ":" + "password";
		String authString = "50301" + ":" + "88888888";
		String auth = "Basic "
				+ new sun.misc.BASE64Encoder().encode(authString.getBytes());
		httpUrl.setRequestProperty("Proxy-Authorization", auth);
 
		// ����ָ������Դ
		httpUrl.connect();
		// ��ȡ����������
		bis = new BufferedInputStream(httpUrl.getInputStream());
		// �����ļ�
		fos = new FileOutputStream(fileName);
 
		if (this.DEBUG)
			System.out.println("���ڻ�ȡ����[" + destUrl + "]������...\n���䱣��Ϊ�ļ�["
					+ fileName + "]");
		// �����ļ�
		while ((size = bis.read(buf)) != -1)
			fos.write(buf, 0, size);
 
		fos.close();
		bis.close();
		httpUrl.disconnect();
	}
 
	/**
	 * ���ô��������
	 * 
	 * @param proxy
	 *            String
	 * @param proxyPort
	 *            String
	 */
	public void setProxyServer(String proxy, String proxyPort) {
		// ���ô��������
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", proxy);
		System.getProperties().put("proxyPort", proxyPort);
	}
    
	/*
	 * modify ��Ϊû���ҵ��ϴ��ߵ�MyAuthenticator��,���԰���δ����ע�͵���,���ļ����ع���û��Ӱ��
	 * 
	public void setAuthenticator(String uid, String pwd) {
		Authenticator.setDefault(new MyAuthenticator());
	}
	*/
 
	/**
	 * ������(���ڲ���)
	 * 
	 * @param argv
	 *            String[]
	 */
	





	
        
    }




