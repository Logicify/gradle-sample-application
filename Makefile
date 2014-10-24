start:
	cd gtp
	./gradlew clean build -x test
	./gradlew gtp-web:war
	foreman start -f Procfile-staging
