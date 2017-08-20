
package com.ljq.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;

/** 
 * @author lujunqiang 
 * Date: 2017年8月14日 上午11:10:03 
 *
 */
public class FreemarkerTest {
	
	private static final String BASEPATH = System.getProperty("user.dir"); // 项目绝对路径
	private static final String CONTRACT = "/resource/contract/";//合同文件存储路径
	private static final String TEMPLATE = "/resource/templates/";//模板存储路径

	private static final String PDFNAME = "pdfDemo";//生成的pdf文件名
	private static final String HTMLNAME = "pdfDemo";//html文件名
	
	public static void contractHandler(String templateName,
			HashMap<String,Object> paramMap) throws Exception{
		// 获取本地模板存储路径、合同文件存储路径
		String templatePath = BASEPATH + TEMPLATE;
		String contractPath = BASEPATH + CONTRACT;
		// 组装html和pdf合同的全路径URL
		String localHtmlUrl = contractPath + HTMLNAME + ".html";
		String localPdfPath = contractPath + "/";
		// 判断本地路径是否存在如果不存在则创建
		File localFile = new File(localPdfPath);
		if (!localFile.exists()) {
			localFile.mkdirs();
		}
		String localPdfUrl = localFile + "/" + PDFNAME + ".pdf";
		templateName=templateName+".ftl";
		htmHandler(templatePath, templateName, localHtmlUrl, paramMap);// 生成html合同
//		pdfHandler(localHtmlUrl, localPdfUrl);// 根据html合同生成pdf合同
//		deleteFile(localHtmlUrl);// 删除html格式合同
		
		System.out.println("PDF生成成功");
	}
	
	/**
	 * 生成html格式合同
	 */
	private static void htmHandler(String templatePath, String templateName,
			String htmUrl, HashMap<String, Object> paramMap) throws Exception {
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		System.out.println("templasemap: " + templatePath);
		cfg.setDirectoryForTemplateLoading(new File(templatePath));
        System.out.println("templateName: " + templateName);
		Template template = cfg.getTemplate(templateName);

		File outHtmFile = new File(htmUrl);

		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(outHtmFile)));
		template.process(paramMap, out);

		out.close();
	}
	
	/**
	 * 生成pdf格式合同
	 */
	private static void pdfHandler(String htmUrl, String pdfUrl)
			throws DocumentException, IOException {
		File htmFile = new File(htmUrl);
		File pdfFile = new File(pdfUrl);

		String url = htmFile.toURI().toURL().toString();
        System.out.println("url: " + url);
		OutputStream os = new FileOutputStream(pdfFile);

		org.xhtmlrenderer.pdf.ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(url);

		ITextFontResolver fontResolver = renderer
				.getFontResolver();
		// 解决中文支持问题
		fontResolver.addFont(BASEPATH + TEMPLATE+"simsun.ttc",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		renderer.layout();
		renderer.createPDF(os);
		os.close();
	}
	
	/**
	 * 删除文件
	 */
	private static void deleteFile(String fileUrl) {
		File file = new File(fileUrl);
		file.delete();
	}
	
	public static void main(String[] args) throws Exception {
		String templateName = "ca_ncbank_protocal";
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("isBorrower", 1);
		List<String> testLists = new  ArrayList<>();
		for (int i = 0; i < 20; i++) {
			testLists.add("test ||||||" + i);
		}
		paramMap.put("testLists", testLists);
		
		contractHandler(templateName, paramMap);
	}
	
	
}
