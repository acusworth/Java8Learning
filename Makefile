GRADLE_OPTIONS?=--info --stacktrace
GR=./gradlew $(GRADLE_OPTIONS)


build: ## Builds the project without running tests
	$(GR) build -x test

test: ## Runs all the test packages
	$(GR) test

run: ## Runs the program
	$(GR) run