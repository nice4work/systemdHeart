SETTING_PATH = /Users/joy/Documents/java/javaTools/apache-maven-3.8.2/conf/maven_release_setting.xml



compile:
	mvn clean compile

install:
	mvn clean install -Possrh -s ${SETTING_PATH}


deploy:
	 mvn deploy -Possrh -s ${SETTING_PATH}



