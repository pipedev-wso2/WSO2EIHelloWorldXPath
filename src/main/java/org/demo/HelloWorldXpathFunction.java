package org.demo;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.SynapseConstants;
import org.jaxen.Context;
import org.jaxen.Function;
import org.jaxen.FunctionCallException;
import org.jaxen.function.StringFunction;

public class HelloWorldXpathFunction implements Function {
	private final org.apache.synapse.MessageContext synCtx;

	public HelloWorldXpathFunction(org.apache.synapse.MessageContext synCtx) {
		this.synCtx = synCtx;
	}

	public Object call(Context context, List args) throws FunctionCallException {
		String arg = StringFunction.evaluate(args.get(0), context.getNavigator());
		try {
			String value = "<Hello " + arg + "!!!>";
			return value;
		} catch (Exception msg) {
			throw new FunctionCallException(msg);
		}
	}
}