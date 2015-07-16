package com.eachedu.service;

@RequestScoped
public class TestServiceImpl implements TestService{

	@Override
	public String showMsg(String source) throws Exception {
		
		return "this is method from [showMsg] process :"+source;
	}

}
