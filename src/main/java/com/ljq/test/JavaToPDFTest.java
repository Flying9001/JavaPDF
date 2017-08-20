package com.ljq.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ljq.utils.PDFUtil;
import com.ljq.utils.PathUtil;

public class JavaToPDFTest {
   private static final boolean DBG = false;
	
	@Test
	public void PDFTest() {
		String basePath = PathUtil.getPath();
		if(DBG) { System.out.println("JavaToPDFTest.PDFTest basePath: " + basePath); }
		String htmlTmpFile = basePath + "/resource/template/test1.html";
		String fontFile = basePath + "/resource/font/simsun.ttc";
		String pdfFile = basePath + "/resource/pdf/test1.pdf";
		
		Map<String,Object> dataMap = new HashMap<>();
		// dataMap 中的数据要与模板中的对应
		dataMap.put("username", "魔术师");
		dataMap.put("idnum", "A100001");
		
		String htmlTmpStr = PDFUtil.freemarkerRender(dataMap, htmlTmpFile);
		
		PDFUtil.createPDF(htmlTmpStr, fontFile, pdfFile);
		
		
	}
	
	
}
