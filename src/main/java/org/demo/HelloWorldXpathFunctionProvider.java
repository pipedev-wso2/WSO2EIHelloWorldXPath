package org.demo;


import javax.xml.namespace.QName;
import org.apache.synapse.MessageContext;
import org.apache.synapse.util.xpath.ext.SynapseXpathFunctionContextProvider;
import org.jaxen.Function;

public class HelloWorldXpathFunctionProvider implements SynapseXpathFunctionContextProvider {

	private static final String NAMESPACE_PREFIX = "samples";
	private static final String FUNCTION_NAME = "helloworld";

	public Function getInitializedExtFunction(MessageContext messageContext) {
		HelloWorldXpathFunction resolver = new HelloWorldXpathFunction(messageContext);
		return resolver;
	}

	public QName getResolvingQName() {
		return new QName(null, FUNCTION_NAME, NAMESPACE_PREFIX);
	}
}