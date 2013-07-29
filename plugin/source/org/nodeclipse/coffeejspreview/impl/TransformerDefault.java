package org.nodeclipse.coffeejspreview.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import org.nodeclipse.coffeejspreview.api.CoffeeJSConfig;

public class TransformerDefault {

	public void setConfig(CoffeeJSConfig config, Logger logger) {
		// TODO Auto-generated method stub
		
	}

//	private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);

	public void transformCoffeeFile(File coffeeFile, File htFile) throws IOException{
//        String mdText = FileUtils.readFileToString(mdFile, UTF_8);
//        String htText = transformMarkdownText(mdText);
//        CompiledTemplate htmlTemplate = TemplateCompiler.compileTemplate(gfmConfig.getHtmlTemplate());
//        Map<String, Object> vars = new HashMap<String, Object>();
//        vars.put("title", htFile.toString());
//        vars.put("content", htText);
//        vars.put("cssText", gfmConfig.getCssText());
//        vars.put("cssUris", gfmConfig.getCssUris());
//        vars.put("jsText", gfmConfig.getJsText());
//        vars.put("jsUris", gfmConfig.getJsUris());
//        String rendered = (String) TemplateRuntime.execute(htmlTemplate, vars);
//        FileUtils.writeStringToFile(htFile, rendered, UTF_8);
	}

	public boolean isCoffeeFile(File file) {
		// TODO Auto-generated method stub
		return false;
	}

}
