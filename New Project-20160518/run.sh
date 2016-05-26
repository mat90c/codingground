#!/bin/bash

rm ./*.class
javac -cp . HelloWorld.java
java HelloWorld
