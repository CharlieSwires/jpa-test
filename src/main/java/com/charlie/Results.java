package com.charlie;

import java.util.List;

public class Results {

	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Results [results=" + results + "]";
	}
	
}
