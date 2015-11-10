JAVA = javac
SOURCES = $(wildcard src/**/*.java)
FLAGS = -Xlint:deprecation -classpath
CLASS_PATH = src/
APPLET = appletviewer

compile:
	$(JAVA) $(FLAGS) $(CLASS_PATH) $(SOURCES)

exec: clean compile
	$(APPLET) index.html

.PHONY: clean
clean:
	-rm -rf src/**/*.class src/**/**/*.class src/**/**/**/*.class
