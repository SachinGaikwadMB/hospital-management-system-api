package com.mb.api.business.constant;

public enum StatusCode
{	
	INTERNAL_SERVER_ERROR(500),
	ADMIN_ALREADY_EXIST(608);

	private final int value;

	private StatusCode(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}
}
