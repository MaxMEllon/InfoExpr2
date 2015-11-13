JAVA       = javac
RUNNER     = java
SOURCES    = $(wildcard src/**/*.java)
FLAGS      = -encoding UTF-8 -Xlint:deprecation -J-Dfile.encoding=UTF-8
CLASS_PATH = -classpath src/
BUILD_DIR  = bin/
BUILD_PATH = -d $(BUILD_DIR)
APPLET     = appletviewer

compile:
	@[ -d $(BUILD_DIR) ] || mkdir -p $(BUILD_DIR)
	$(JAVA) $(FLAGS) $(CLASS_PATH) $(BUILD_PATH) $(SOURCES)

exec: clean compile
	$(APPLET) index.html

test: clean compile
	$(RUNNER) -classpath $(BUILD_DIR) Test.UnitTest

.PHONY: clean
clean:
	-rm -rf $(BUILD_DIR)
