package com.adictos.tutorial.architecture.context.holder;

public interface ContextHolder {

	<T> T locate(Class<T> clazz);
}
