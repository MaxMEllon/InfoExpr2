JAVA = javac
SOURCES = $(wildcard src/**/*.java)
CLASSES = $(addprefix ./, $(SOURCES:.java=.class))
FLAGS = -encoding UTF-8 -Xlint:deprecation
CLASS_PATH = -classpath src/
APPLET = appletviewer

compile:
	$(JAVA) $(FLAGS) $(CLASS_PATH) $(SOURCES)

exec: clean compile
	$(APPLET) index.html

.PHONY: clean
clean:
	-rm -rf $(CLASSES) src/**/**/**/*.class
