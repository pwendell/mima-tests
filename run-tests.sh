#!/bin/bash
# Can be automated later to run many tests

VERSION=1.0 SOURCE_DIR=private-inner-class/before/ sbt publish-local
VERSION=1.0 SOURCE_DIR=private-inner-class/after/ sbt mima-report-binary-issues

