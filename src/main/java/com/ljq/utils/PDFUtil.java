package com.ljq.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class PDFUtil {
    private static final boolean DBG = false;
	
	/**
	 * 使用 Freemarker 渲染 html
	 * @param dataMap 传入 thml 模板的 Map 数据
	 * @param htmlTmpFile thml 模板文件(路径+文件名)
	 * 
	 * */
	public static String freemarkerRender(Map<String,Object> dataMap, String htmlTmpFile) {
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		Writer out = new StringWriter();
		try {
			// 解决跨系统文件路径问题
			int num = htmlTmpFile.lastIndexOf('/');
			if(num == -1) {
				num = htmlTmpFile.lastIndexOf('\\');
			}
			if(DBG) { System.out.println("JavaToPDFUtil.freemarkerRender num: " + num); }
			// 获取模板
			cfg.setDirectoryForTemplateLoading(new File(htmlTmpFile.substring(0,num)));
			Template template = cfg.getTemplate(htmlTmpFile.substring(num));
			// 将数据写入模板
			template.process(dataMap, out);
			out.flush();
            return out.toString();
            
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 使用 Itext 生成 PDF 文档
	 * @param htmlTmpStr html 模板文件字符串
	 * @param fontFile 所需字体文件(路径+文件名)
	 * @param pdfFile 生成的 PDF 文件(路径+文件名)
	 * 
	 * */
	public static void createPDF(String htmlTmpStr,String fontFile,String pdfFile) {
		File pdf = new File(pdfFile);
		try {
			OutputStream out = new FileOutputStream(pdf);
			ITextRenderer renderer = new ITextRenderer();
			if(DBG) { System.out.println("JavaToPDFUtil.createPDF htmlTmpStr: " + htmlTmpStr); }
			renderer.setDocumentFromString(htmlTmpStr);
			ITextFontResolver fontResolver = renderer.getFontResolver();
			// 解决中文支持问题,需要所需字体(ttc)文件
			fontResolver.addFont(fontFile,BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

			renderer.layout();
			renderer.createPDF(out);
			if(out != null) {
				out.close();
			}
			if(DBG) { System.out.println("JavaToPDFUtil.createPDF PDF created !"); }
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
