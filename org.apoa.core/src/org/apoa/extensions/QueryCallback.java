package org.apoa.extensions;

import java.util.List;

public interface QueryCallback {
	public void process(List<QueryResult> result);
}
