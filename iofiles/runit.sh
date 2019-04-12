#!/bin/bash
javac /home/priyanka/ee_workspace/ACMS/iofiles/hello.java 2> /home/priyanka/ee_workspace/ACMS/iofiles/error
java -cp iofiles hello < /home/priyanka/ee_workspace/ACMS/iofiles/input1 > /home/priyanka/ee_workspace/ACMS/iofiles/output