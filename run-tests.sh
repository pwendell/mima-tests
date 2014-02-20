#!/bin/bash
# Can be automated later to run specific tests, output nicely, etc.

SOURCE_DIR=private-inner-class/before/ sbt publish-local
SOURCE_DIR=private-inner-class/after/ sbt mima-report-binary-issues

SOURCE_DIR=package-private-class/before/ sbt publish-local
SOURCE_DIR=package-private-class/after/ sbt mima-report-binary-issues
