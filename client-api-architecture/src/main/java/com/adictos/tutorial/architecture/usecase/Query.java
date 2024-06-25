package com.adictos.tutorial.architecture.usecase;

public abstract class Query<T> extends UseCase<T> {

	protected <R> R run(Query<R> otherQuery) {
		return runInternal(otherQuery);
	}
}
