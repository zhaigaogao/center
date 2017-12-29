package learn.center.thinkInJava.unit11.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		Integer[] moreInts={7,8,9};
		collection.addAll(Arrays.asList(moreInts));
	}
}
