package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import org.zkoss.zk.scripting.SerializableAware;

import Reflection.ReflectionClass;
import intefaces.IModel;
import util.Return;

public abstract class Model<T extends Object> implements IModel, Serializable{
	private String classe;

	
}
