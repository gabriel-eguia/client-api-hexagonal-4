package com.adictos.tutorial.architecture.usecase;

public abstract class UseCase<T> {

	protected abstract T run();

	protected T execute() {
		return run();
	}
}
