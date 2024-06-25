package com.adictos.tutorial.architecture.usecase;

public abstract class Command<T> extends UseCase<T> {

	protected <R> R run(UseCase<R> otherUsecase) {
		return runInternal(otherUsecase);
	}
}
