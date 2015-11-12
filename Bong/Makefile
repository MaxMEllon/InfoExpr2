JAVA       = javac
SOURCES    = $(wildcard src/**/*.java)
FLAGS      = -encoding UTF-8 -Xlint:deprecation -Xdiags:verbose -J-Dfile.encoding=UTF-8
CLASS_PATH = -classpath src/
BUILD_DIR  = bin/
BUILD_PATH = -d $(BUILD_DIR)
APPLET     = appletviewer

compile:
	@[ -d $(BUILD_DIR) ] || mkdir -p $(BUILD_DIR)
	$(JAVA) $(FLAGS) $(CLASS_PATH) $(BUILD_PATH) $(SOURCES)

exec: clean compile
	$(APPLET) index.html

.PHONY: clean
clean:
	-rm -rf $(BUILD_DIR)
