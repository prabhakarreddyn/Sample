package com.dsa.formula.test.cases.junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.mouritech.jbrfplus.context.Context;
import com.mouritech.jbrfplus.decisionservice.DecisionService;
import com.mouritech.jbrfplus.decisionservice.DecisionServiceFactory;
import com.mouritech.jbrfplus.decisionservice.Trace;
import com.mouritech.jbrfplus.types.DataObject;
public class FU_ADDITION {

	@Test
	public void test() {
		String system_user_language = "E";
		String system_current_user = "KISHOREY";
		String system_bgprocessing = "X";
		String processingTime = "2017-05-04 17:23:00";

		Trace trace = new Trace("D:\\Trace");
		DecisionService ds = null;
		DataObject result = null;

		try {
			String functionID = "002590F0DB231ED69AD0E65CC0488934";
			Context context = new Context();
			context.set("IV_INPUT", 5);
			context.set("IV_INPUT1", 2);	
			if (functionID != null && !functionID.trim().isEmpty())
				ds = (DecisionService) DecisionServiceFactory
				.getFunctionById(functionID,processingTime);
			else
				ds = (DecisionService) DecisionServiceFactory
						.getFunctionByName(functionID, processingTime);

			ds.setClientProperties(system_current_user, system_user_language,
					system_bgprocessing);
			ds.setContext(context);
			if (trace != null) {
				ds.process(trace);
				trace.save("ABC");
			} else {
				ds.process();
			}
			result = (DataObject) ds.getResult();
			System.err.println("Result from DSA Tool ::::::::::::::::::::"
					+ result);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
