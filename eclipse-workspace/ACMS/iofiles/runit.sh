#!/bin/bash
javac /home/hima/eclipse-workspace/ACMS/iofiles/hello.java 2> /home/hima/eclipse-workspace/ACMS/iofiles/error
java -cp iofiles hello < /home/hima/eclipse-workspace/ACMS/iofiles/input1 > /home/hima/eclipse-workspace/ACMS/iofiles/output