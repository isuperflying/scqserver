package com.ant.scq.lib.base;

import com.ant.scq.entity.DataStore;

public abstract class SenderWapper {

	protected DataStore requestData = new DataStore();

	public abstract ISender getSender();
}
