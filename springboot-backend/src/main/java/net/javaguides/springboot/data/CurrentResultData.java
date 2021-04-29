package net.javaguides.springboot.data;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.domain.Result;

@Component
public class CurrentResultData {

	private Result result = new Result();

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}


}
