package de.predic8.cameldemo;

import org.apache.camel.Processor;
import org.apache.camel.builder.script.ScriptBuilder;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class Utils {
	public static Processor javascript(String scriptResourceName) {
		try {
			String driver = "jvm-npm.js";
			return new ScriptBuilder("javaScript", ""
					+ "load({name:'"+driver+"',script:com.google.common.io.CharStreams.toString("+
					"new java.io.InputStreamReader(java.lang.Thread.currentThread().getContextClassLoader()."+
					"getResourceAsStream('"+driver+"'), com.google.common.base.Charsets.UTF_8))});\n"
					+ Resources.toString(Resources.getResource(scriptResourceName), Charsets.UTF_8));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
